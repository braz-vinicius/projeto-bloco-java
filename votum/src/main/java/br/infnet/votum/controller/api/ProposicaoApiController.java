package br.infnet.votum.controller.api;

import br.infnet.votum.model.Proposicao;
import br.infnet.votum.service.ProposicaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProposicaoApiController {

    private final ProposicaoService proposicaoService;

    public ProposicaoApiController(ProposicaoService proposicaoService) {
        this.proposicaoService = proposicaoService;
    }

    /**
     * Lista proposições
     * @return List<Proposicao></Proposicao>
     */
    @ApiOperation(value = "Lista todas proposições", notes = "Lista as proposições cadastradas no sistema ordenadas pela sua data de criação de forma decrescente.")
    @GetMapping("/api/proposicao")
    public List<Proposicao> get() {

        return proposicaoService.obterLista();
    }
}
