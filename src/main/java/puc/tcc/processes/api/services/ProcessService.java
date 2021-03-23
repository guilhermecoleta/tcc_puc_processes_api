package puc.tcc.processes.api.services;


import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.resources.process.create.ProcessCreateRequest;

import java.util.List;
import java.util.Optional;

public interface ProcessService {
    ProcessEntity create(final ProcessCreateRequest process);

    Optional<ProcessEntity> findById(final Long id);

    List<ProcessEntity> findAll();

    void delete(final Long id) throws ProcessesApiException;
}
