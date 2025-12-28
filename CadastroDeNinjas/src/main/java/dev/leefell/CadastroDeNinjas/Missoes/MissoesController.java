package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes") // localhost:8080/missoes/criar
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoees() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesPorID(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO MissoesDTO) {
        return missoesService.criarMissao(MissoesDTO);
    }

    @PutMapping("/atualizar/{id}")
    public MissoesDTO atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorID(@PathVariable Long id) {
        missoesService.deletarMissaoPorID(id);
    }
}
