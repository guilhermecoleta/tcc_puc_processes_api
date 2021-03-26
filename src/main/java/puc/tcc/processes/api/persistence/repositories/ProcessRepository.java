package puc.tcc.processes.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {

}
