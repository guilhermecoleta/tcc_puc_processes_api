package puc.tcc.processes.api.services;


import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.resources.process.ProcessRequest;
import puc.tcc.processes.api.resources.process.ProcessResponse;

import java.util.List;
import java.util.Optional;

public interface ProcessService {
    ProcessResponse saveOrUpdate(final ProcessRequest process) throws ProcessesApiException;

    Optional<ProcessResponse> findById(final Long id);

    List<ProcessResponse> findAll();

    void delete(final Long id) throws ProcessesApiException;
}
