package puc.tcc.processes.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.resources.process.create.ProcessCreateRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProcessMapper {

    @Mappings({
            @Mapping(source = "request.number", target = "number"),
            @Mapping(source = "request.priority", target = "priority"),
            @Mapping(source = "request.documentId", target = "documentId"),
            @Mapping(source = "request.productId", target = "productId"),
            @Mapping(source = "request.quantityProduct", target = "quantityProduct")
    })
    ProcessEntity create(ProcessCreateRequest request);


}
