package puc.tcc.processes.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.tcc.processes.api.persistence.domain.ProcessStatusEntity;

@Repository
public interface ProcessStatusRepository extends JpaRepository<ProcessStatusEntity, Long> {

}
