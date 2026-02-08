package dev.leefell.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/")
    @Operation(summary = "Cria uma nova missão", description = "A rota cria uma nova missão e a insere no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Missão criada com sucesso."), @ApiResponse(responseCode = "400", description = "Erro ao criar missão.")})
    public ResponseEntity<MissoesDTO> criarMissao(@Valid @RequestBody MissoesDTO missaoDTO) {
        MissoesDTO novaMissao = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMissao);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Altera uma missão pelo ID", description = "A rota atualiza a missão pelo ID recebido.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso."), @ApiResponse(responseCode = "404", description = "Erro ao atualizar a missão.")})
    public ResponseEntity<MissoesDTO> atualizarMissao(@Valid @PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
        if (missao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(missao);
    }

    @GetMapping("/")
    @Operation(summary = "Lista todas as missões", description = "A rota devolve uma lista com todas as missões cadastradas")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Lista de missões retornada com sucesso.")})
    public ResponseEntity<List<MissoesDTO>> listarMissoees() {
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista uma missão por ID", description = "A rota devolve uma missão baseado no ID recebido")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso."), @ApiResponse(responseCode = "404", description = "Missão não encontrada.")})
    public ResponseEntity<MissoesDTO> listarMissoesPorID(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorID(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(missao);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma missão por ID", description = "A rota deleta uma missão baseado no ID recebido")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Missão deletada com sucesso."), @ApiResponse(responseCode = "404", description = "Missão não encontrada.")})
    public ResponseEntity<Void> deletarMissaoPorID(@Parameter(description = "ID da missão a ser deletada") @PathVariable Long id) {
        boolean deletado = missoesService.deletarMissaoPorID(id);
        if (!deletado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
