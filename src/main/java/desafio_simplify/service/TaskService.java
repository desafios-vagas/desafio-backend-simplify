package desafio_simplify.service;

import desafio_simplify.dto.TaskRequestDTO;
import desafio_simplify.dto.TaskResponseDTO;
import desafio_simplify.entity.Task;
import desafio_simplify.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
