package puc.tcc.processes.api.resources.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puc.tcc.processes.api.exception.ProcessesApiException;
import puc.tcc.processes.api.mapper.ProcessMapper;
import puc.tcc.processes.api.persistence.domain.ProcessEntity;
import puc.tcc.processes.api.services.ProcessService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProcessResource {

    @Autowired
    private ProcessService processService;

    @Autowired
    private ProcessMapper processMapper;

    @PostMapping(value = "/processes", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessResponse> create(@Valid @RequestBody final ProcessRequest processRequest) {
        ProcessEntity body = processService.create(processRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(processMapper.toResponse(body));
    }

    @PutMapping(value = "/processes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessResponse> update(@PathVariable("id") Long id, @Valid @RequestBody final ProcessRequest processRequest) throws ProcessesApiException {
        ProcessEntity body = processService.update(id, processRequest);
        return ResponseEntity.ok(processMapper.toResponse(body));
    }

    @GetMapping(value = "/processes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessResponse> findById(@PathVariable("id") Long id) throws ProcessesApiException {
        var response = processService.findById(id);
        return response.map(processEntity -> ResponseEntity.ok(processMapper.toResponse(processEntity))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/processes")
    public ResponseEntity<List<ProcessResponse>> findAll(){
        var list = processService.findAll();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        List<ProcessResponse> processes = new ArrayList<>();
        list.forEach(item -> processes.add(processMapper.toResponse(item)));
        return ResponseEntity.ok(processes);
    }

    @DeleteMapping(value = "/processes/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws ProcessesApiException {
        processService.delete(id);
        return ResponseEntity.ok().build();
    }

}
