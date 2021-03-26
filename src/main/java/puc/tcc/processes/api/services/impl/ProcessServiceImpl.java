package puc.tcc.processes.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.mapper.ProcessMapper;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.persistence.repositories.ProcessRepository;
import puc.tcc.processes.api.resources.process.ProcessRequest;
import puc.tcc.processes.api.services.ProcessService;
import puc.tcc.processes.api.services.ProcessStageService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private ProcessStageService stageService;

    @Override
    @Transactional
    public ProcessEntity create(ProcessRequest processRequest) {
        var entity = processMapper.create(processRequest);
        entity.setDatCreate(LocalDateTime.now());
        entity.setDatUpdate(LocalDateTime.now());

        return processRepository.save(entity);
    }

    @Override
    @Transactional
    public ProcessEntity update(Long id, ProcessRequest processRequest) throws ProcessesApiException {
        var entity = processMapper.create(processRequest);
        var process = findById(id);
        entity.setId(id);
        entity.setCurrentStage(process.get().getCurrentStage());
        entity.setPreviousStage(process.get().getPreviousStage());
        entity.setNextStage(process.get().getNextStage());
        entity.setDatUpdate(LocalDateTime.now());
        return processRepository.save(entity);
    }

    private ProcessEntity notFound() throws ProcessesApiException {
        throw new ProcessesApiException(HttpStatus.NOT_FOUND, "process", "Processo não existe!");
    }

    @Override
    public Optional<ProcessEntity> findById(Long id) throws ProcessesApiException {
        var process = processRepository.findById(id);
        if(process.isEmpty()){
            notFound();
        }

        return process;
    }

    @Override
    public List<ProcessEntity> findAll() {
        return processRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) throws ProcessesApiException {
        stageService.deleteByProcess(id);
        var process = findById(id);
        processRepository.delete(process.get());
    }
}
