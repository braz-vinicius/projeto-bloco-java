package br.infnet.votum.repository;

import br.infnet.votum.model.Pessoa;
import br.infnet.votum.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("FROM Usuario WHERE email = ?1")
    Usuario findByUsername(String email);
}
