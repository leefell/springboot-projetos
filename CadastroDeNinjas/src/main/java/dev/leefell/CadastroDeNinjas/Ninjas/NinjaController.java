package dev.leefell.CadastroDeNinjas.Ninjas;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas") // Define a URL base para os endpoints deste controller
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/")
    public ResponseEntity<NinjaDTO> criarNinja(@Valid @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoNinja);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<NinjaDTO> atualizarNinja(@Valid @PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ninja);
    }

    @GetMapping("/")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<Void> deletarNinjaPorID(@PathVariable Long id) {
        boolean deletado = ninjaService.deletarNinjaPorID(id);
        if (!deletado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}