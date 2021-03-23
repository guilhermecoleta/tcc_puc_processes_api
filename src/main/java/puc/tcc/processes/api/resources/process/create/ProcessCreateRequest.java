package puc.tcc.processes.api.resources.process.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessCreateRequest {
    @NotNull(message = "O campo nome deve ser preenchido")
    private Long number;
    @NotNull(message = "O campo nome deve ser preenchido")
    private Integer priority;
    @NotNull(message = "O campo nome deve ser preenchido")
    @JsonProperty(value = "document_id")
    private Long documentId;
    @NotNull(message = "O campo nome deve ser preenchido")
    @JsonProperty(value = "product_id")
    private Long productId;
    @NotNull(message = "O campo nome deve ser preenchido")
    @JsonProperty(value = "quantity_product")
    private Integer quantityProduct;
}
