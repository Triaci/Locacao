package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.LocacaoModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/locacao")
public class LocacaoController extends BaseController<LocacaoModel>{
    @Override
    public List<LocacaoModel> list() {
        return null;
    }
}
