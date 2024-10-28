package desafio_simplify.controller;

import desafio_simplify.dto.TaskRequestDTO;
import desafio_simplify.dto.TaskResponseDTO;
import desafio_simplify.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO request){
        TaskResponseDTO taskResponseDTO = service.create(request);
        return ResponseEntity.status(201).body(taskResponseDTO);
    }
}
