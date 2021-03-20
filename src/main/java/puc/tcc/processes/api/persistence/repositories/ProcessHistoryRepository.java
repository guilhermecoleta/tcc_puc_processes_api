package puc.tcc.processes.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.tcc.processes.api.persistence.domain.ProcessHistoryEntity;

@Repository
public interface ProcessHistoryRepository extends JpaRepository<ProcessHistoryEntity, Long> {

}
