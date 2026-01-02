package dev.leefell.CadastroDeNinjas.Ninjas;

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

    @PostMapping("/criar") // @RequestBody -> sinaliza que o usuário tem que mandar uma requisição com corpo
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaDTO> listarNinjaPorID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorID(id);
        if (ninja == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(ninja);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<NinjaDTO> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ninja);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {
        boolean deletado = ninjaService.deletarNinjaPorID(id);
        if (!deletado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não encontrado.");
        }
        return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso");
    }

}