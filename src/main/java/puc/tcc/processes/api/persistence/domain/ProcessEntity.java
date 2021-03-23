package puc.tcc.processes.api.persistence.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "process")
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProcessEntity implements Serializable {
    private static final String SEQ_PROCESS_GEN = "SEQ_PROCESS_GEN";
    private static final String SEQ_PROCESS = "SEQ_PROCESS";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PROCESS_GEN)
    @SequenceGenerator(name = SEQ_PROCESS_GEN, sequenceName = SEQ_PROCESS, allocationSize = 1)
    private Long id;
    private Long number;
    private Integer priority;
    @Column(name = "document_id")
    @JsonProperty(value = "document_id")
    private Long documentId;
    @ManyToOne
    @JsonProperty(value = "previous_stage")
    @JoinColumn(name = "previous_stage")
    private ProcessStageEntity previousStage;
    @ManyToOne
    @JsonProperty(value = "current_stage")
    @JoinColumn(name = "current_stage")
    private ProcessStageEntity currentStage;
    @ManyToOne
    @JoinColumn(name = "next_stage")
    @JsonProperty(value = "next_stage")
    private ProcessStageEntity nextStage;
    @Column(name = "product_id")
    @JsonProperty(value = "product_id")
    private Long productId;
    @JsonProperty(value = "quantity_product")
    @Column(name = "quantity_product")
    private Integer quantityProduct;
}
