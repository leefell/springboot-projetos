package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {

        // 1: "Traduz" o missaoDTO vindo do controller para missaoModel
        MissoesModel missao = missoesMapper.map(missoesDTO);

        // 2: Salva o objeto no banco de dados como missaoModel
        missao = missoesRepository.save(missao);

        // 3: Converte o resultado novamente em missaoDTO e devolve pro cliente
        return missoesMapper.map(missao);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        MissoesModel missao = missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));

        missoesMapper.atualizaEntidadePeloDTO(missoesDTO, missao);

        MissoesModel missaoSalva = missoesRepository.save(missao);

        return missoesMapper.map(missaoSalva);
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorID(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    public boolean deletarMissaoPorID(Long id) {
        if (!missoesRepository.existsById(id)) {
            return false;
        }

        try {
            missoesRepository.deleteById(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(
                    "Não é possível deletar a missão, pois existem ninjas vinculados a ela"
            );
        }
    }

}
