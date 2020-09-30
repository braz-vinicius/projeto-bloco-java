package br.infnet.votum.controller;

import br.infnet.votum.model.Proposicao;
import br.infnet.votum.service.ProposicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class ProposicaoController {
    @Autowired
    private ProposicaoService proposicaoService;

    @RequestMapping(value = "/proposicao", method = RequestMethod.GET)
    public String read(Model model) {
        List<Proposicao> proposicaoList = proposicaoService.obterLista();

        model.addAttribute("lista", proposicaoList);
        return "proposicao";
    }

    @RequestMapping(value = "/proposicao", method = RequestMethod.POST)
    public String create(Proposicao proposicao, Model model) {

        proposicaoService.incluir(proposicao);
        model.addAttribute("lista", proposicaoService.obterLista());

        return "proposicao";
    }

}
