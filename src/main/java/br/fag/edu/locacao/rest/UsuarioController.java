package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.UsuarioModel;
import br.fag.edu.locacao.repository.UsuarioRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping(value = "/usuario")
    public class UsuarioController extends BaseController<UsuarioModel>{

        @Autowired
        private UsuarioRB usuarioRB;

        @Override
        public List<UsuarioModel> list() {
            List<UsuarioModel> usuario = usuarioRB.findAll();
            return  usuario;
        }
    }

