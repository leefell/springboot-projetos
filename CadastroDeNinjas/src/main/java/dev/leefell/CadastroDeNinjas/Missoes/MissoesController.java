package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes") // localhost:8080/missoes/criar
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoees() {
        return "Missões listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso";
    }
}
