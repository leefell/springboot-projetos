package dev.leefell.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setRank(ninjaModel.getRank());

        return ninjaDTO;
    }

    public void atualizaEntidadePeloDTO(NinjaDTO dto, NinjaModel model){
        if(dto.getNome() != null){
            model.setNome(dto.getNome());
        }

        if(dto.getEmail() != null){
            model.setEmail(dto.getEmail());
        }

        if(dto.getIdade() != null){
            model.setIdade(dto.getIdade());
        }

        if(dto.getMissoes() != null){
            model.setMissoes(dto.getMissoes());
        }

        if(dto.getRank() != null){
            model.setRank(dto.getRank());
        }
    }

}
