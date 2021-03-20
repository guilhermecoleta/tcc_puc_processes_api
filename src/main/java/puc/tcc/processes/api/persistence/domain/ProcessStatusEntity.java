package puc.tcc.processes.api.persistence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "process_status")
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProcessStatusEntity implements Serializable {
    private static final String SEQ_PROCESS_STATUS_GEN = "SEQ_PROCESS_STATUS_GEN";
    private static final String SEQ_PROCESS_STATUS = "SEQ_PROCESS_STATUS";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PROCESS_STATUS_GEN)
    @SequenceGenerator(name = SEQ_PROCESS_STATUS_GEN, sequenceName = SEQ_PROCESS_STATUS, allocationSize = 1)
    private Long id;

    private String name;
}
