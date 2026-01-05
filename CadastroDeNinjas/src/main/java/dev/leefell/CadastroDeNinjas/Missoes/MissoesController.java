package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/")
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missaoDTO) {
        MissoesDTO novaMissao = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMissao);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MissoesDTO> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
        if (missao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(missao);
    }

    @GetMapping("/")
    public ResponseEntity<List<MissoesDTO>> listarMissoees() {
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissoesDTO> listarMissoesPorID(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorID(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(missao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMissaoPorID(@PathVariable Long id) {
        boolean deletado = missoesService.deletarMissaoPorID(id);
        if (!deletado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
