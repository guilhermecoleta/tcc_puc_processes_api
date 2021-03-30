package puc.tcc.processes.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.mapper.ProcessMapper;
import puc.tcc.processes.api.mapper.ProcessStageMapper;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;
import puc.tcc.processes.api.persistence.repositories.ProcessRepository;
import puc.tcc.processes.api.persistence.repositories.ProcessStageRepository;
import puc.tcc.processes.api.resources.proccess.stage.ProcessStageRequest;
import puc.tcc.processes.api.resources.proccess.stage.ProcessStageResponse;
import puc.tcc.processes.api.resources.proccess.stage.ProcessWorkflowResponse;
import puc.tcc.processes.api.services.ProcessService;
import puc.tcc.processes.api.services.ProcessStageService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessStageServiceImpl implements ProcessStageService {

    @Autowired
    private ProcessStageRepository processStageRepository;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private ProcessStageMapper processStageMapper;

    @Autowired
    private ProcessMapper processMapper;

    @Transactional
    @Override
    public List<ProcessStageEntity> create(List<ProcessStageRequest> stages, Long processId) throws ProcessesApiException {
        var process = processService.findById(processId);
        var list = new ArrayList<ProcessStageEntity>();
        var currentStages = findAll(process.orElseThrow().getId());

        validate(stages, process.orElseThrow(), currentStages);

        for (var request: stages) {
            var processStage = processStageMapper.create(request);
            Optional<ProcessStageEntity> stage = processStage.getId() != null? processStageRepository.findById(processStage.getId()) : Optional.empty();
            if(stage.isPresent()){
                processStage.setDatStart(stage.orElseThrow().getDatStart());
                processStage.setDatEnd(stage.orElseThrow().getDatEnd());
            }
            processStage.setProcess(process.orElseThrow());
            if(process.orElseThrow().getCurrentStage() == null){
                process.orElseThrow().setCurrentStage(processStage);
                processStage.setDatStart(LocalDateTime.now());
            }else if(process.orElseThrow().getNextStage() == null){
                process.orElseThrow().setNextStage(processStage);
            }
            processStage = processStageRepository.save(processStage);
            list.add(processStage);
        }
        processRepository.save(process.orElseThrow());
        delete(process.orElseThrow(), list);
        return list;
    }

    private void validate(List<ProcessStageRequest> stages, ProcessEntity process, List<ProcessStageEntity> currentStages) throws ProcessesApiException {
        var stagesIds = stages.stream().map(ProcessStageRequest::getId).collect(Collectors.toList());
        var differences = currentStages.stream()
                .filter(element -> !stagesIds.contains(element.getId()))
                .collect(Collectors.toList());

        validateStageFinished(process, differences);
    }

    private void delete(ProcessEntity process, ArrayList<ProcessStageEntity> list) {
        var currentStages = findAll(process.getId());

        List<ProcessStageEntity> differences = currentStages.stream()
                .filter(element -> !list.contains(element))
                .collect(Collectors.toList());

        processStageRepository.deleteAll(differences);
    }

    private void validateStageFinished(ProcessEntity process, List<ProcessStageEntity> differences) throws ProcessesApiException {
        var processStage = differences.stream().filter(processStageEntity -> processStageEntity.getId().equals(process.getCurrentStage().getId()) || processStageEntity.getDatStart() != null).findFirst();
        if (processStage.isPresent()) {
            throw new ProcessesApiException(HttpStatus.BAD_REQUEST, "stages-" + processStage.get().getId(), "Não foi possível executar essa ação, pois a etapa já terminou");
        }
    }

    @Override
    public List<ProcessStageEntity> findAll(Long processId){
        return processStageRepository.findByProcessIdOrderByIdAsc(processId);
    }

    @Override
    @Transactional
    public void deleteByProcess(Long processId){
        var stages = findAll(processId);
        processStageRepository.deleteAll(stages);
    }

    @Transactional
    @Override
    public ProcessWorkflowResponse finishStage(Long processId, String note) throws ProcessesApiException {
        var process = processService.findById(processId);
        var processEntity = process.orElseThrow();
        finishCurrentStage(note, processEntity.getCurrentStage());

        processEntity.setPreviousStage(processEntity.getCurrentStage());
        if(processEntity.getNextStage() != null){
            processEntity.setCurrentStage(processEntity.getNextStage());
            processEntity.getCurrentStage().setDatStart(LocalDateTime.now());
            var nextStage = processStageRepository.findFirstByProcessIdAndIdGreaterThanOrderByIdAsc(processId, processEntity.getCurrentStage().getId());
            processEntity.setNextStage(nextStage);
        }else{
            processEntity.setNextStage(null);
        }
        processRepository.save(processEntity);

        processStageRepository.save(processEntity.getCurrentStage());

        var processStageList= getProcessStageResponses(findAll(processId));
        var processResponse = processMapper.toResponse(processEntity);
        return new ProcessWorkflowResponse(processResponse, processStageList);
    }

    private List<ProcessStageResponse> getProcessStageResponses(List<ProcessStageEntity> request) {
        List<ProcessStageResponse> stages = new ArrayList<>();
        request.forEach(item -> stages.add(processStageMapper.toResponse(item)));
        return stages;
    }

    private void finishCurrentStage(String note, ProcessStageEntity processStage) {
        processStage.setNote(note);
        processStage.setDatEnd(LocalDateTime.now());

        processStageRepository.save(processStage);
    }

    public Optional<ProcessStageEntity> findById(Long id) throws ProcessesApiException {
        var processStage = processStageRepository.findById(id);
        if(processStage.isEmpty()){
            notFound();
        }

        return processStage;
    }

    private void notFound() throws ProcessesApiException {
        throw new ProcessesApiException(HttpStatus.NOT_FOUND, "processStage", "Etapa não existe!");
    }

}
