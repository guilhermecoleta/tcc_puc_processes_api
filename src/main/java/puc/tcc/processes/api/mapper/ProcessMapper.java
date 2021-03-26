package puc.tcc.processes.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.resources.process.ProcessRequest;
import puc.tcc.processes.api.resources.process.ProcessResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProcessMapper {

    @Mappings({
            @Mapping(source = "request.number", target = "number"),
            @Mapping(source = "request.priority", target = "priority"),
            @Mapping(source = "request.documentId", target = "documentId"),
            @Mapping(source = "request.productId", target = "productId"),
            @Mapping(source = "request.quantityProduct", target = "quantityProduct")
    })
    ProcessEntity create(ProcessRequest request);

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.number", target = "number"),
            @Mapping(source = "entity.priority", target = "priority"),
            @Mapping(source = "entity.documentId", target = "documentId"),
            @Mapping(source = "entity.productId", target = "productId"),
            @Mapping(source = "entity.quantityProduct", target = "quantityProduct"),
            @Mapping(source = "entity.datCreate", target = "datCreate", dateFormat = "dd/MM/yyyy HH:mm:ss"),
            @Mapping(source = "entity.datUpdate", target = "datUpdate", dateFormat = "dd/MM/yyyy HH:mm:ss"),
            @Mapping(source = "entity.currentStage.id", target = "currentStage.id"),
            @Mapping(source = "entity.currentStage.name", target = "currentStage.name"),
            @Mapping(source = "entity.nextStage.id", target = "nextStage.id"),
            @Mapping(source = "entity.nextStage.name", target = "nextStage.name")
    })
    ProcessResponse toResponse(ProcessEntity entity);


}
