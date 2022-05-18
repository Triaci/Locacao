package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.LocacaoModel;
import br.fag.edu.locacao.repository.LocacaoRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/locacao")
public class LocacaoController extends BaseController<LocacaoModel>{

    @Autowired
    private LocacaoRB locacaoRB;
    @Override
    public List<LocacaoModel> list() {
         List<LocacaoModel> locacao = locacaoRB.findAll();
        return  locacao;

    }

    @Override
    public LocacaoModel find(String id) {
        return locacaoRB.getById(UUID.fromString(id));

    }

    @Override
    public void insert(LocacaoModel insertObjeto) {

    }
}
