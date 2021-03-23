package puc.tcc.processes.api.persistence.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProcessStatusEnum {
    INITIALIZED("Iniciado"),
    PENDING("Pendente"),
    FINISHED("Concluído");

    private String status;
}
