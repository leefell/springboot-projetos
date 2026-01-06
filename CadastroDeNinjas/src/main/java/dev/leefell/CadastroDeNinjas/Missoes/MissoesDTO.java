package dev.leefell.CadastroDeNinjas.Missoes;

import dev.leefell.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    @NotBlank
    @Size(max = 50)
    private String nome;
    @NotBlank
    private String dificuldade;
    private List<NinjaModel> ninjas;

}
