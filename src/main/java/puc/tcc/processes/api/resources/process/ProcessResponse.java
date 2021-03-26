package puc.tcc.processes.api.resources.process;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import puc.tcc.processes.api.resources.proccess.stage.ProcessStageResponse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessResponse {
    private Long id;
    private Long number;
    private Integer priority;
    @JsonProperty(value = "document_id")
    private Long documentId;
    @JsonProperty(value = "current_stage")
    private ProcessStageResponse currentStage;
    @JsonProperty(value = "next_stage")
    private ProcessStageResponse nextStage;
    @JsonProperty(value = "product_id")
    private Long productId;
    @JsonProperty(value = "quantity_product")
    private Integer quantityProduct;
    @JsonProperty(value = "dat_update")
    private String datUpdate;
    @JsonProperty(value = "dat_create")
    private String datCreate;
}
