package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.model.LocacaoModel;
import br.fag.edu.locacao.repository.LocacaoRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<?> insert(LocacaoModel locacao) {
            if(locacao.getValorLocado() <= 0){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Valor Inválido!");

            } else if(locacao.getDtInicio() == null || locacao.getDtFim() == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Data Inválida!");

            }

            locacaoRB.saveAndFlush(locacao);
            return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<?> update(@RequestBody LocacaoModel updateObjeto) {
        LocacaoModel locacaoModel = locacaoRB.findById(updateObjeto.getId()).get();

        if (updateObjeto.getValorLocado() == 0){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Valor Inválido!");
        }
        if (updateObjeto.getDtFim() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Data Inválida!");
        }
        if (updateObjeto.getDtInicio() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Data Inválida!");
        }

        updateObjeto.setValorLocado(locacaoModel.getValorLocado());
        updateObjeto.setDtFim(locacaoModel.getDtFim());
        updateObjeto.setDtInicio(locacaoModel.getDtInicio());

        locacaoRB.saveAndFlush(updateObjeto);
        return ResponseEntity.ok().build();
    }
}
