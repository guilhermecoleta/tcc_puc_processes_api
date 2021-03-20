package puc.tcc.processes.api.persistence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "process_stage")
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProcessStageEntity implements Serializable {
    private static final String SEQ_PROCESS_STAGE_GEN = "SEQ_PROCESS_STAGE_GEN";
    private static final String SEQ_PROCESS_STAGE = "SEQ_PROCESS_STAGE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PROCESS_STAGE_GEN)
    @SequenceGenerator(name = SEQ_PROCESS_STAGE_GEN, sequenceName = SEQ_PROCESS_STAGE, allocationSize = 1)
    private Long id;
    private String observation;
    private String note;
    private Integer order;
    @Column(name = "expected_dat_start")
    private LocalDateTime expectedDatStart;
    @Column(name = "dat_start")
    private LocalDateTime datStart;
    @Column(name = "expected_dat_end")
    private LocalDateTime expectedDatEnd;
    @Column(name = "expected_dat_end")
    private LocalDateTime datEnd;
    @ManyToOne
    @JoinColumn(name = "process_id")
    private ProcessEntity process;
    @ManyToOne
    @JoinColumn(name = "stage_id")
    private StageEntity stage;
}
