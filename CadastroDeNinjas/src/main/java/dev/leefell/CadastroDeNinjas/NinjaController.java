package dev.leefell.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controller REST (retorna dados, não páginas HTML)
@RequestMapping // Define a URL base para os endpoints deste controller
public class NinjaController {

    @GetMapping("/boasvindas") // Mapeia requisições GET no caminho "/boasvindas"
    public String boasVindas(){
        return "Primeira rota da aplicação";
    }

}