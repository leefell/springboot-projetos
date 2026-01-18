package dev.leefell.CadastroDeNinjas.Ninjas;

import dev.leefell.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// JPA = Java Persistence API
// Lombok cria o construtor, getter e setters de acordo com a Annotation,
// e msm que tenha novos atributos ele atualiza tb

@Entity // transorma uma classe em entidade do DB
@Table(name = "tb_ninjas")
@Data // Cria getters e setters
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id // O Atributo abaixo dele é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreign Key
    private MissoesModel missoes;

}
