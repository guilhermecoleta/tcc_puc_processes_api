package puc.tcc.processes.api.resources.proccess.stage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.mapper.ProcessStageMapper;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;
import puc.tcc.processes.api.resources.process.ProcessResponse;
import puc.tcc.processes.api.services.ProcessStageService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RestController
public class ProcessStageResource {

    @Autowired
    private ProcessStageService stageService;

    @Autowired
    private ProcessStageMapper processStageMapper;

    @PostMapping(value = "/processes/{process}/stages", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProcessStageResponse>> create(@Valid @RequestBody final List<ProcessStageRequest> request, @PathVariable(value = "process") Long processId) throws ProcessesApiException {
        List<ProcessStageEntity> list = stageService.create(request, processId);
        List<ProcessStageResponse> stages = getProcessStageResponses(list);

        return ResponseEntity.status(HttpStatus.CREATED).body(stages);
    }

    @GetMapping(value = "/processes/{process}/stages",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProcessStageResponse>> findAll( @PathVariable(value = "process") Long processId) {
        List<ProcessStageEntity> list = stageService.findAll(processId);
        if(list.isEmpty()) return ResponseEntity.notFound().build();

        List<ProcessStageResponse> stages = getProcessStageResponses(list);

        return ResponseEntity.ok(stages);
    }

    private List<ProcessStageResponse> getProcessStageResponses(List<ProcessStageEntity> request) {
        List<ProcessStageResponse> stages = new ArrayList<>();
        request.forEach(item -> stages.add(processStageMapper.toResponse(item)));
        return stages;
    }


    @PostMapping(value = "/processes/{process}/current-stage/finish", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessWorkflowResponse> finish(@Valid @RequestBody final ProcessStageFinishRequest request, @PathVariable(value = "process") Long processId) throws ProcessesApiException {
        var response = stageService.finishStage(processId, request.getNote());
        return ResponseEntity.ok(response);
    }
}
