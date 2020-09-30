package br.infnet.votum.controller;

import br.infnet.votum.model.Voto;
import br.infnet.votum.model.VotoEnum;
import br.infnet.votum.service.PessoaService;
import br.infnet.votum.service.ProposicaoService;
import br.infnet.votum.service.VotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class VotoController {

    private final VotoService votoService;
    private final PessoaService pessoaService;
    private final ProposicaoService proposicaoService;

    public VotoController(VotoService votoService,
                          PessoaService pessoaService,
                          ProposicaoService proposicaoService) {
        this.votoService = votoService;
        this.pessoaService = pessoaService;
        this.proposicaoService = proposicaoService;
    }

    private void setLista(Model model) {
        model.addAttribute("lista", votoService.obterLista());
        model.addAttribute("listaPessoa", pessoaService.obterLista());
        model.addAttribute("listaProposicao", proposicaoService.obterLista());
        model.addAttribute("listaTipoVoto", VotoEnum.values());
    }

    @RequestMapping(value = "/voto", method = RequestMethod.GET)
    public String read(Model model) {
        setLista(model);
        return "voto";
    }

    @RequestMapping(value = "/voto", method = RequestMethod.POST)
    public String create(Model model, Voto voto) {

        votoService.incluir(voto);
        setLista(model);

        return "voto";
    }

}

