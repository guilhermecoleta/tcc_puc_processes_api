package puc.tcc.processes.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.tcc.processes.api.persistence.domain.StageEntity;

@Repository
public interface StageRepository extends JpaRepository<StageEntity, Long> {

}
