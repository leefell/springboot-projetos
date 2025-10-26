package dev.leefell.CadastroDeNinjas.Ninjas;

import org.hibernate.annotations.SoftDelete;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que esta classe é um controller REST (retorna dados, não páginas HTML)
@RequestMapping // Define a URL base para os endpoints deste controller
public class NinjaController {

    @GetMapping("/boasvindas") // Mapeia requisições GET no caminho "/boasvindas"
    public String boasVindas() {
        return "Primeira rota da aplicação";
    }

    // Adiciona (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar (READ)
    @GetMapping("/todos")
    public String buscarTodosOsNinjas(){
        return "Todos os ninjas";
    }

    // Procura por ID (READ)
    @GetMapping("/ID")
    public String buscarNinjaPorID(){
        return "ninja com id tal";
    }

    // Alterar dados (UPDATE)
    @PutMapping("/ID")
    public String alterarNinjaPorID(){
        return "Ninja alterado";
    }

    // Deletar (DELETE)
    @DeleteMapping("/ID")
    public String deletarNinjaPorID(){
        return "Ninja deletado";
    }
}