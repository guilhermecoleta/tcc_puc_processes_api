package puc.tcc.processes.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.tcc.processes.api.persistence.domain.StageEntity;
import puc.tcc.processes.api.persistence.repositories.StageRepository;
import puc.tcc.processes.api.services.StageService;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {
    @Autowired
    private StageRepository stageRepository;

    @Override
    public List<StageEntity> findAll() {
        return stageRepository.findAll();
    }
}
