package desafio_simplify.controller;

import desafio_simplify.dto.TaskRequestDTO;
import desafio_simplify.dto.TaskResponseDTO;
import desafio_simplify.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/list")
    public List<TaskResponseDTO> getAllTasks(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        TaskResponseDTO taskResponseDTO = service.getTaskById(id);
        return ResponseEntity.ok(taskResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO requestDTO){
        TaskResponseDTO taskResponseDTO = service.updateTask(id, requestDTO);
        return ResponseEntity.ok(taskResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
