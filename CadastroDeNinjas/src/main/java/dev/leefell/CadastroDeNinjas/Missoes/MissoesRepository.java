package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
    // JPA é uma abstração que facilita a comunicação entre a aplicação e o banco de dados,
    // permitindo realizar operações crud sem precisar escrever SQL manualmente.
    // <MissoesModel -> classe escaneada, Long -> tipo do id da classe escaneada>
}
