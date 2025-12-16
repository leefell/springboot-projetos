package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissoesPorID(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return  missoesModel.orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){

        // 1: "Traduz" o missaoDTO vindo do controller para missaoModel
        MissoesModel missao = missoesMapper.map(missoesDTO);

        // 2: Salva o objeto no banco de dados como missaoModel
        missao = missoesRepository.save(missao);

        // 3: Converte o resultado novamente em missaoDTO e devolve pro cliente
        return missoesMapper.map(missao);
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }
}
