package puc.tcc.processes.api.resources.proccess.stage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import puc.tcc.processes.api.resources.process.ProcessResponse;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessWorkflowResponse {
    @JsonProperty(value = "process")
    private ProcessResponse processResponse;
    @JsonProperty(value = "stages")
    private List<ProcessStageResponse> processStageResponse;
}
