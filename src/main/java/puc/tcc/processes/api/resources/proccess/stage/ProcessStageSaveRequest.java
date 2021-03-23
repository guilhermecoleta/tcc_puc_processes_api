package puc.tcc.processes.api.resources.proccess.stage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessStageSaveRequest {
    private Long id;
    private String observation;
    private Integer order;
    @JsonProperty(value = "expected_dat_start")
    private LocalDateTime expectedDatStart;
    @JsonProperty(value = "expected_dat_end")
    private LocalDateTime expectedDatEnd;
    @JsonProperty(value = "process_id")
    private Long processId;
    private String name;
}
