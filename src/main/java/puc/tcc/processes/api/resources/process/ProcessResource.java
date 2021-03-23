package puc.tcc.processes.api.resources.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.resources.process.create.ProcessCreateRequest;
import puc.tcc.processes.api.services.ProcessService;

import javax.validation.Valid;

@RestController
public class ProcessResource {

    @Autowired
    private ProcessService processService;

    @PostMapping(value = "/processes", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessEntity> create(@Valid @RequestBody final ProcessCreateRequest processCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(processService.create(processCreateRequest));
    }

}
