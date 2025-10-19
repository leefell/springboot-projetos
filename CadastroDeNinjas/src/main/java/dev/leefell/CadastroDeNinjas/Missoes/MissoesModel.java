package dev.leefell.CadastroDeNinjas.Missoes;

import dev.leefell.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // @OneToMany - uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes") // mapeando o relacionamento através da chave estrangeira
    private List<NinjaModel> ninjas;

}
