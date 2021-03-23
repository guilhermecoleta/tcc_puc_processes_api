package puc.tcc.processes.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.mapper.ProcessMapper;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.persistence.repositories.ProcessRepository;
import puc.tcc.processes.api.resources.process.create.ProcessCreateRequest;
import puc.tcc.processes.api.services.ProcessService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private ProcessRepository processRepository;

    @Override
    @Transactional
    public ProcessEntity create(ProcessCreateRequest processCreateRequest) {
        var entity = processMapper.create(processCreateRequest);
        return processRepository.save(entity);
    }

    @Override
    @Transactional
    public ProcessEntity update(Long id, ProcessCreateRequest processCreateRequest) throws ProcessesApiException {
        var entity = processMapper.create(processCreateRequest);
        var process = findById(id);
        if(process.isEmpty()){
            return notFound();
        }
        entity.setId(id);
        entity.setCurrentStage(process.get().getCurrentStage());
        entity.setPreviousStage(process.get().getPreviousStage());
        entity.setNextStage(process.get().getNextStage());
        return processRepository.save(entity);
    }

    private ProcessEntity notFound() throws ProcessesApiException {
        throw new ProcessesApiException(HttpStatus.NOT_FOUND, "process", "Processo não existe!");
    }

    @Override
    public Optional<ProcessEntity> findById(Long id) {
        return processRepository.findById(id);
    }

    @Override
    public List<ProcessEntity> findAll() {
        return processRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) throws ProcessesApiException {
        var process = findById(id);
        if(process.isEmpty()){
            notFound();
        }
        processRepository.delete(process.get());
    }
}
