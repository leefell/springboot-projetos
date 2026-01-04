package dev.leefell.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){

        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){

        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }

    public void atualizaEntidadePeloDTO(MissoesDTO dto, MissoesModel model){
        if (dto.getNome() != null){
            model.setNome(dto.getNome());
        }

        if(dto.getDificuldade() != null){
            model.setDificuldade(dto.getDificuldade());
        }

        if(dto.getNinjas() != null){
            model.setNinjas(dto.getNinjas());
        }
    }

}
