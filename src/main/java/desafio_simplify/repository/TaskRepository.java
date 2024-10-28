package desafio_simplify.repository;

import desafio_simplify.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long > {

}
