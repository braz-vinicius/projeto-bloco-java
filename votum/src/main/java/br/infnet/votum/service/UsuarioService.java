package br.infnet.votum.service;

import br.infnet.votum.model.Usuario;
import br.infnet.votum.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;


    public UsuarioService(IUsuarioRepository usuarioRepository, InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.usuarioRepository = usuarioRepository;

        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    public List<Usuario> obterLista() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        inMemoryUserDetailsManager.createUser(new User(usuario.getEmail(),
                encoder.encode(usuario.getSenha()),
                new ArrayList<GrantedAuthority>()));

    }

    public void incluirFoto() {

    }
}
