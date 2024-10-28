package desafio_simplify.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "realizado", nullable = false)
    private boolean realizado = false;

    @Column(name = "prioridade", nullable = false)
    private int prioridade;

}
