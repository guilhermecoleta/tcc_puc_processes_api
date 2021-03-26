package puc.tcc.processes.api.persistence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private Long documentId;
    @ManyToOne
    @JoinColumn(name = "previous_stage")
    private ProcessStageEntity previousStage;
    @ManyToOne
    @JoinColumn(name = "current_stage")
    private ProcessStageEntity currentStage;
    @ManyToOne
    @JoinColumn(name = "next_stage")
    private ProcessStageEntity nextStage;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity_product")
    private Integer quantityProduct;
    @Column(name = "dat_update")
    private LocalDateTime datUpdate;
    @Column(name = "dat_create")
    private LocalDateTime datCreate;
}
