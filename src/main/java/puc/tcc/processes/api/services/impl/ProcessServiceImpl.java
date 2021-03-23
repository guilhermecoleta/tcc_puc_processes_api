package puc.tcc.processes.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.mapper.ProcessMapper;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.persistence.domain.ProcessStatusEnum;
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
        entity.setProcessStatus(ProcessStatusEnum.INITIALIZED);
        return processRepository.save(entity);
    }

    @Override
    public Optional<ProcessEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProcessEntity> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) throws ProcessesApiException {

    }
}
