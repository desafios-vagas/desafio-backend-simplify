package desafio_simplify.dto;

import lombok.Data;

@Data
public class TaskResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

}
