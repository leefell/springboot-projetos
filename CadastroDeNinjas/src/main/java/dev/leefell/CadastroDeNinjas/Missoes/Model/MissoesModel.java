package dev.leefell.CadastroDeNinjas.Missoes.Model;

import dev.leefell.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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
