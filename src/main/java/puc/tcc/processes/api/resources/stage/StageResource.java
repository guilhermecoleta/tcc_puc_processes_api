package puc.tcc.processes.api.resources.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.tcc.processes.api.persistence.domain.StageEntity;
import puc.tcc.processes.api.services.StageService;

import java.util.List;

@RestController
public class StageResource {
    @Autowired
    private StageService stageService;

    @GetMapping("/stages")
    public ResponseEntity<List<StageEntity>> findAll(){
        var stages = stageService.findAll();
        return ResponseEntity.ok(stages);
    }
}
