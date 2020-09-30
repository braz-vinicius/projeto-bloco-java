package br.infnet.votum.controller;

import br.infnet.votum.model.Pessoa;
import br.infnet.votum.model.PessoaFisica;
import br.infnet.votum.model.PessoaJuridica;
import br.infnet.votum.model.PessoaPolitica;
import br.infnet.votum.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(@Autowired PessoaService pessoaService) {

        this.pessoaService = pessoaService;
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public String read(Model model, String tipoPessoa) {
        if(tipoPessoa.isEmpty()) {
            tipoPessoa = "pessoaFisica";
        }
        setLista(model, tipoPessoa);
        return "pessoa/"+tipoPessoa;
    }

    @RequestMapping(value = "/pessoa/fisica", method = RequestMethod.POST)
    public String createPessoaFisica(Model model, PessoaFisica pessoa) {
        pessoaService.incluir(pessoa);
        setLista(model, "pessoaFisica");
        return "pessoa/pessoaFisica";
    }

    @RequestMapping(value = "/pessoa/juridica", method = RequestMethod.POST)
    public String createPessoaJuridica(Model model, PessoaJuridica pessoa) {
        pessoaService.incluir(pessoa);
        setLista(model, "pessoaJuridica");
        return "pessoa/pessoaJuridica";
    }

    @RequestMapping(value = "/pessoa/politica", method = RequestMethod.POST)
    public String createPessoaPolitica(Model model, PessoaPolitica pessoa) {
        pessoaService.incluir(pessoa);
        setLista(model, "pessoaPolitica");
        return "pessoa/pessoaPolitica";
    }
    private void setLista(Model model, String tipoPessoa) {
        model.addAttribute("lista", pessoaService.obterPorTipo(tipoPessoa));
    }
}
