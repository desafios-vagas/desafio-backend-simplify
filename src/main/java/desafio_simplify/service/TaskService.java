package desafio_simplify.service;

import desafio_simplify.dto.TaskRequestDTO;
import desafio_simplify.dto.TaskResponseDTO;
import desafio_simplify.entity.Task;
import desafio_simplify.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public TaskResponseDTO create(TaskRequestDTO input) {
        Task task = new Task();
        task.setNome(input.getNome());
        task.setDescricao(input.getDescricao());
        task.setPrioridade(input.getPrioridade());
        repository.save(task);
        return mapToDTO(task);
    }

    public List<TaskResponseDTO>  getAllTasks(){
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TaskResponseDTO getTaskById(Long id){
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return mapToDTO(task);
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO input){
        Task task = repository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        task.setNome(input.getNome());
        task.setDescricao(input.getDescricao());
        task.setPrioridade(input.getPrioridade());
        task.setRealizado(input.isRealizado());
        repository.save(task);
        return mapToDTO(task);
    }


public void deleteTask(Long id){
        repository.deleteById(id);

}
    private TaskResponseDTO mapToDTO(Task task){
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();

        taskResponseDTO.setId(task.getId());
        taskResponseDTO.setNome(task.getNome());
        taskResponseDTO.setDescricao(task.getDescricao());
        taskResponseDTO.setRealizado(task.isRealizado());
        taskResponseDTO.setPrioridade(task.getPrioridade());
        return taskResponseDTO;
    }

}
