package puc.tcc.processes.api.persistence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stage")
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StageEntity implements Serializable {
    private static final String SEQ_STAGE_GEN = "SEQ_STAGE_GEN";
    private static final String SEQ_STAGE = "SEQ_STAGE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_STAGE_GEN)
    @SequenceGenerator(name = SEQ_STAGE_GEN, sequenceName = SEQ_STAGE, allocationSize = 1)
    private Long id;
    private String name;
}
