package dev.leefell.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Injeção de dependência
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        // Metodo do JPA que executa automaticamente uma query SELECT * FROM na tabela de ninjas
        return ninjaRepository.findAll();
    }

    // Listar ninjas por ID
    public NinjaModel listarNinjaPorID(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null); // Se o ninja existir ele vai retornar, se não null
    }

    // Criar um ninja
    public NinjaModel criarNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    // Deletar o ninja
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }
}
