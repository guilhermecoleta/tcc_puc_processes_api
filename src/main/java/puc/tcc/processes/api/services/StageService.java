package puc.tcc.processes.api.services;

import puc.tcc.processes.api.persistence.domain.StageEntity;

import java.util.List;

public interface StageService {
    List<StageEntity> findAll();
}
