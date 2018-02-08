/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.aula.natan.controller;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.repository.UsuarioRepository;
import io.spring.aula.natan.service.UsuarioService;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    UsuarioRepository repository;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listUsuario() {
        return this.usuarioService.listaUsuario();
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deletarUsuario(@PathVariable String id) {
        this.usuarioService.deletarUsuario(id);
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario consultarUsuario(@PathVariable String id) {
        return this.usuarioService.consultarUsuario(id);
    }
    
    @RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
    public Page<Usuario> listaPaginadaUsuarios(@PathVariable int page,@PathVariable int count) {
        return this.usuarioService.listaPaginadaUsuarios(page, count);
    }

    @RequestMapping(value = "/usuario/{nome}/nome", method = RequestMethod.GET)
    public List<Usuario> listPaginada(@PathVariable String nome) {
        return this.usuarioService.buscaPorNome(nome);
    }
    
    @RequestMapping(value = "/usuario/logado", method = RequestMethod.GET)
    @ResponseBody
    public Usuario currentUserName(Principal principal) {
        Usuario usuario = this.repository.findByEmail(principal.getName());
        usuario.setSenha("");
        return usuario;
    }
}
