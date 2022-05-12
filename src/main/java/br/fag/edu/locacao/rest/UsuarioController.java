package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.UsuarioModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping(value = "/usuario")
    public class UsuarioController extends BaseController<UsuarioModel>{

        @Override
        public List<UsuarioModel> list() {
            return new ArrayList<>();
        }
    }


