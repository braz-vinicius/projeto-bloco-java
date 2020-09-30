package br.infnet.votum.service;

import br.infnet.votum.model.Pessoa;
import br.infnet.votum.model.PessoaFisica;
import br.infnet.votum.repository.IPessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final IPessoaRepository pessoaRepository;

    public PessoaService(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void incluir(Pessoa pessoa) {
        this.pessoaRepository.save(pessoa);
    }

    public List<Pessoa> obterPorTipo(String tipoPessoa) {
        return (List<Pessoa>) this.pessoaRepository.findByTipo(tipoPessoa);
    }
    public List<Pessoa> obterLista() {
       return (List<Pessoa>) this.pessoaRepository.findAll();
    }
}
