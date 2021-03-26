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
public class ProcessStageRequest {
    private Long id;
    private String observation;
    @JsonProperty(value = "expected_dat_start")
    private LocalDateTime expectedDatStart;
    @JsonProperty(value = "expected_dat_end")
    private LocalDateTime expectedDatEnd;
    private String name;
}
