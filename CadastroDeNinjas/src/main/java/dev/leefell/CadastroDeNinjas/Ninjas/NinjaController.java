package dev.leefell.CadastroDeNinjas.Ninjas;

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
@RequestMapping("/ninjas") // Define a URL base para os endpoints deste controller
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/status")
    @Operation(summary = "Rota que checa se a API está rodando")
    public String status() {
        return "API rodando normalmente";
    }

    @PostMapping("/")
    @Operation(summary = "Cria um novo ninja", description = "A rota cria um novo ninja e o insere no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."), @ApiResponse(responseCode = "400", description = "Erro ao criar ninja.")})
    public ResponseEntity<NinjaDTO> criarNinja(@Valid @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoNinja);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Altera um ninja pelo ID", description = "A rota atualiza o ninja pelo ID recebido.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso."), @ApiResponse(responseCode = "404", description = "Erro ao atualizar o ninja.")})
    public ResponseEntity<NinjaDTO> atualizarNinja(@Valid @PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ninja);
    }

    @GetMapping("/")
    @Operation(summary = "Lista todos os ninjas", description = "A rota devolve uma lista com todos os ninjas cadastrados")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Lista de ninjas retornada com sucesso.")})
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista um ninja por ID", description = "A rota devolve um ninja baseado no ID recebido")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso."), @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")})
    public ResponseEntity<NinjaDTO> listarNinjaPorID(@PathVariable Long id) {
        // Pode deixar genérico, assim podendo passar uma mensagem no body caso n encontre ou
        // retornando o model caso encontre
        NinjaDTO ninja = ninjaService.listarNinjaPorID(id);
        if (ninja == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(ninja);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um ninja por ID", description = "A rota deleta um ninja baseado no ID recebido")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Ninja deletado com sucesso."), @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")})
    public ResponseEntity<Void> deletarNinjaPorID(@Parameter(description = "ID do ninja a ser deletado") @PathVariable Long id) {
        boolean deletado = ninjaService.deletarNinjaPorID(id);
        if (!deletado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}