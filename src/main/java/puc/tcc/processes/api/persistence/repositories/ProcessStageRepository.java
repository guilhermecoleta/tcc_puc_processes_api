package puc.tcc.processes.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;

import java.util.List;

@Repository
public interface ProcessStageRepository extends JpaRepository<ProcessStageEntity, Long> {

    List<ProcessStageEntity> findByProcessIdOrderByIdAsc(@Param("processId") Long processId);

    ProcessStageEntity findFirstByProcessIdAndIdGreaterThanOrderByIdAsc(@Param("processId") Long process, @Param("id") Long id);

}
