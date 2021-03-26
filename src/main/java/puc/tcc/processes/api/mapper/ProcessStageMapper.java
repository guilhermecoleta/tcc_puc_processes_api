package puc.tcc.processes.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import puc.tcc.processes.api.persistence.domain.ProcessStageEntity;
import puc.tcc.processes.api.resources.proccess.stage.ProcessStageRequest;
import puc.tcc.processes.api.resources.proccess.stage.ProcessStageResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProcessStageMapper {

    @Mappings({
            @Mapping(source = "request.id", target = "id"),
            @Mapping(source = "request.observation", target = "observation"),
            @Mapping(source = "request.expectedDatStart", target = "expectedDatStart"),
            @Mapping(source = "request.expectedDatEnd", target = "expectedDatEnd"),
            @Mapping(source = "request.name", target = "name"),
    })
    ProcessStageEntity create(ProcessStageRequest request);

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.observation", target = "observation"),
            @Mapping(source = "entity.note", target = "note"),
            @Mapping(source = "entity.name", target = "name"),
            @Mapping(source = "entity.expectedDatStart", target = "expectedDatStart", dateFormat = "dd/MM/yyyy HH:mm:ss"),
            @Mapping(source = "entity.datStart", target = "datStart", dateFormat = "dd/MM/yyyy HH:mm:ss"),
            @Mapping(source = "entity.expectedDatEnd", target = "expectedDatEnd", dateFormat = "dd/MM/yyyy HH:mm:ss"),
            @Mapping(source = "entity.datEnd", target = "datEnd", dateFormat = "dd/MM/yyyy HH:mm:ss")

    })
    ProcessStageResponse toResponse(ProcessStageEntity entity);
}