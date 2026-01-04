package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes") // localhost:8080/missoes/criar
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missaoDTO) {
        MissoesDTO novaMissao = missoesService.criarMissao(missaoDTO);
        if (novaMissao != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Missão criada com sucesso: " + novaMissao.getNome() +
                            " de dificuldade: " + novaMissao.getDificuldade());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível criar a missão");
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.listarMissoesPorID(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão a ser atualizada não foi encontrada");
        }
        MissoesDTO missaoAtualizadaFinal =
                missoesService.atualizarMissao(id, missaoAtualizada);

        return ResponseEntity.ok(missaoAtualizadaFinal);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoees() {
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorID(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorID(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão de id: " + id + " não existe.");
        }
        return ResponseEntity.ok(missao);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorID(@PathVariable Long id) {
        boolean deletado = missoesService.deletarMissaoPorID(id);
        if (!deletado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao de ID: " + id + " não pode ser encontrada");
        }
        return ResponseEntity.ok("Missão de ID: " + id + " foi deletada.");
    }
}
