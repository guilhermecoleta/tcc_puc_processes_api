package puc.tcc.processes.api.services;

import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;
import puc.tcc.processes.api.resources.proccess.stage.ProcessStageRequest;
import puc.tcc.processes.api.resources.proccess.stage.ProcessWorkflowResponse;

import javax.transaction.Transactional;
import java.util.List;

public interface ProcessStageService {
    List<ProcessStageEntity> create(List<ProcessStageRequest> stages, Long processId) throws ProcessesApiException;

    List<ProcessStageEntity> findAll(Long processId);

    void deleteByProcess(Long processId);

    @Transactional
    ProcessWorkflowResponse finishStage(Long processId, String note) throws ProcessesApiException;
}
