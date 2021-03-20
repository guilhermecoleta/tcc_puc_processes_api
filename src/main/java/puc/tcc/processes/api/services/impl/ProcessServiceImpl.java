package puc.tcc.processes.api.services.impl;

import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.resources.process.ProcessRequest;
import puc.tcc.processes.api.resources.process.ProcessResponse;
import puc.tcc.processes.api.services.ProcessService;

import java.util.List;
import java.util.Optional;

public class ProcessServiceImpl implements ProcessService {
    @Override
    public ProcessResponse saveOrUpdate(ProcessRequest process) throws ProcessesApiException {
        return null;
    }

    @Override
    public Optional<ProcessResponse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProcessResponse> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) throws ProcessesApiException {

    }
}
