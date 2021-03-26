package puc.tcc.processes.api.resources.proccess.stage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessStageResponse {
    private Long id;
    private String observation;
    private String note;
    @JsonProperty(value = "expected_dat_start")
    private String expectedDatStart;
    @JsonProperty(value = "dat_start")
    private String datStart;
    @JsonProperty(value = "expected_dat_end")
    private String expectedDatEnd;
    @JsonProperty(value = "dat_end")
    private String datEnd;
    private String name;
}
