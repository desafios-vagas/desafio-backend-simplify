package desafio_simplify.dto;

import lombok.Data;

@Data
public class TaskRequestDTO {
    private String nome;
    private String descricao;
    private int prioridade;
}
