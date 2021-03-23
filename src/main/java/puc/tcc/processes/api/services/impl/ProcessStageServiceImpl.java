package puc.tcc.processes.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.tcc.processes.api.persistence.repositories.ProcessStageRepository;
import puc.tcc.processes.api.services.ProcessStageService;

@Service
public class ProcessStageServiceImpl implements ProcessStageService {

    @Autowired
    private ProcessStageRepository processStageRepository;

}
