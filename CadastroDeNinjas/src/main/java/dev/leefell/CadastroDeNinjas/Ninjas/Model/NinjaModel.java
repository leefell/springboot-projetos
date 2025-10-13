package dev.leefell.CadastroDeNinjas.Ninjas.Model;

import dev.leefell.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA = Java Persistence API
//Lombok cria o construtor, getter e setters de acordo com a Annotation,
// e msm que tenha novos atributos ele atualiza tb

@Entity // transorma uma classe em entidade do DB
@Table(name = "tb_ninjas")
@Data // Cria getters e setters
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id // O Atributo abaixo dele é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;
    
    private int idade;

    // @ManyToOne - um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key
    private MissoesModel missoes;

}
