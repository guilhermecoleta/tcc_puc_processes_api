package puc.tcc.processes.api.resources.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.persistence.domain.ProcessStatusEnum;
import puc.tcc.processes.api.resources.process.create.ProcessCreateRequest;
import puc.tcc.processes.api.services.ProcessService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProcessResource {

    @Autowired
    private ProcessService processService;

    @PostMapping(value = "/processes", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessEntity> create(@Valid @RequestBody final ProcessCreateRequest processCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(processService.create(processCreateRequest));
    }

    @PutMapping(value = "/processes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessEntity> update(@PathVariable("id") Long id, @Valid @RequestBody final ProcessCreateRequest processCreateRequest) throws ProcessesApiException {
        return ResponseEntity.ok(processService.update(id, processCreateRequest));
    }

    @GetMapping(value = "/processes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessEntity> findById(@PathVariable("id") Long id){
        var response = processService.findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/processes")
    public ResponseEntity<List<ProcessEntity>> findAll(){
        var response = processService.findAll();
        if(response.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/processes/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws ProcessesApiException {
        processService.delete(id);
        return ResponseEntity.ok().build();
    }

}
