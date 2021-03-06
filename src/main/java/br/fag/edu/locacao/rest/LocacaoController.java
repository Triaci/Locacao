package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.model.LocacaoModel;
import br.fag.edu.locacao.model.UsuarioModel;
import br.fag.edu.locacao.repository.CarroRB;
import br.fag.edu.locacao.repository.LocacaoRB;
import br.fag.edu.locacao.repository.UsuarioRB;
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
    @Autowired
    private CarroRB   carroRB;
    @Autowired
    private UsuarioRB usuarioRB;

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
    public ResponseEntity<?> insert(@RequestBody LocacaoModel locacao) {

            if (locacao.getCarro() == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("Carro deve ser informado");
            }
           CarroModel carroModel = carroRB.findById(locacao.getCarro().getId()).get();
            if (carroModel == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("Carro ID incorreto");
            }

            if (locacao.getUsuario() == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                     .body("Usuário deve ser informado");
             }
             UsuarioModel usuarioModel = usuarioRB.findById(locacao.getUsuario().getId()).get();
             if (usuarioModel == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                     .body("Usuario ID incorreto");
             }


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

    @Override
    public ResponseEntity<?> delete(String id){
        try {
            LocacaoModel locacao = locacaoRB.findById(UUID.fromString(id)).orElse(null);
            locacaoRB.delete(locacao);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Erro ao Excluir" + e.getCause() + " Message " + e.getMessage());
        }
    }

}
