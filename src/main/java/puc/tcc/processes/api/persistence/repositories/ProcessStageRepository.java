package puc.tcc.processes.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;

@Repository
public interface ProcessStageRepository extends JpaRepository<ProcessStageEntity, Long> {

}
