package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
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
    public void insert(LocacaoModel locacao) throws Exception{
            if(locacao.getValorLocado() == Double.parseDouble(null) || locacao.getValorLocado() <= 0){
                throw new Exception("Valor inválido!");

            } else if(locacao.getDtInicio() == null || locacao.getDtFim() == null){
                throw new Exception("Data inválida!");

            }

            locacaoRB.saveAndFlush(locacao);

    }

    @Override
    public void update(LocacaoModel updateObjeto) throws Exception {
        LocacaoModel locacaoModel = locacaoRB.findById(updateObjeto.getId()).get();

        if (updateObjeto.getValorLocado() == 0){
            throw new Exception("Valor Inválido!");
        }
        if (updateObjeto.getDtFim() == null){
            throw new Exception("Data Inválida!");
        }
        if (updateObjeto.getDtInicio() == null){
            throw new Exception("Data Inválida!");
        }

        updateObjeto.setValorLocado(locacaoModel.getValorLocado());
        updateObjeto.setDtFim(locacaoModel.getDtFim());
        updateObjeto.setDtInicio(locacaoModel.getDtInicio());

        locacaoRB.saveAndFlush(updateObjeto);
    }
}
