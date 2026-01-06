package dev.leefell.CadastroDeNinjas.Ninjas;

import dev.leefell.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Min(0)
    private Integer idade;
    private MissoesModel missoes;
    @NotBlank
    private String rank;

}
