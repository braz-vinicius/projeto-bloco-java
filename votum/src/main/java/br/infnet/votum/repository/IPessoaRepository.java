package br.infnet.votum.repository;

import br.infnet.votum.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPessoaRepository extends CrudRepository<Pessoa,Integer> {

    @Query("FROM Pessoa WHERE tipopessoa = ?1")
    List<Pessoa> findByTipo(String tipoPessoa);

}
