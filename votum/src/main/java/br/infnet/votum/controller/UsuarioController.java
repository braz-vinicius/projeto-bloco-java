package br.infnet.votum.controller;

import br.infnet.votum.model.Proposicao;
import br.infnet.votum.model.Usuario;
import br.infnet.votum.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(@Autowired UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String read(Model model) {
        List<Usuario> usuarios = usuarioService.obterLista();

        model.addAttribute("lista", usuarios);
        return "usuario";
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public String create(@RequestParam("foto") MultipartFile file, Usuario usuario, Model model) {

        usuarioService.incluir(usuario);
        model.addAttribute("lista", usuarioService.obterLista());

        return "usuario";
    }


}
