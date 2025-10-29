package dev.leefell.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
