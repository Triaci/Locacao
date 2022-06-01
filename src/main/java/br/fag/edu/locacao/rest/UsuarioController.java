package br.fag.edu.locacao.rest;


import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.model.UsuarioModel;
import br.fag.edu.locacao.repository.UsuarioRB;
import br.fag.edu.locacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
    @RequestMapping(value = "/usuario")
    public class UsuarioController extends BaseController<UsuarioModel>{

        @Autowired
        private UsuarioRB usuarioRB;

        @Autowired
        private UsuarioService usuarioService;

        @Override
        public List<UsuarioModel> list() {
            List<UsuarioModel> usuario = usuarioRB.findAll();
            return  usuario;

        }

        @Override
        public UsuarioModel find(String id) {
            return usuarioRB.getById(UUID.fromString(id));

        }

    @Override
    public ResponseEntity<?> insert(@RequestBody UsuarioModel usuario) {

            if(usuario.getNome() == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Nome Inválido!");

            } else if(usuario.getTelefone() == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Telefone Inválido!");

            }

            try {
                CPFValidator cpfValidator = new CPFValidator();
                cpfValidator.assertValid(usuario.getCpf());
                if(usuarioService.findByCpf(usuario.getCpf()) != null){
                    throw new Exception("CPF Já Cadastrado !");
                }
                
             }catch (Exception e){
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("CPF Inválido!");
            }

            usuarioRB.saveAndFlush(usuario);
            return ResponseEntity.ok().build();
    }
    @Override
    public ResponseEntity<?> update(@RequestBody UsuarioModel updateObjeto) {
        UsuarioModel usuarioModel = usuarioRB.findById(updateObjeto.getId()).get();

        try {
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(usuarioModel.getCpf());
            if(usuarioService.findByCpf(usuarioModel.getCpf()) != null){
                throw new Exception("CPF Já Cadastrado !");
            }
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("CPF Inválido!");
        }

        if (updateObjeto.getNome()  == null){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Nome Inválido!");
        }
        if(updateObjeto.getTelefone()  == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Telefone Inválido!");
        }else{updateObjeto.setTelefone(usuarioModel.getNome());}

        updateObjeto.setNome(usuarioModel.getNome());
        updateObjeto.setCpf(usuarioModel.getCpf());

        usuarioRB.saveAndFlush(updateObjeto);
        return ResponseEntity.ok().build();

    }


    @Override
    public ResponseEntity<?> delete(String id){
        try {
            UsuarioModel usuario = usuarioRB.findById(UUID.fromString(id)).orElse(null);
            usuarioRB.delete(usuario);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Erro ao Excluir" + e.getCause() + " Message " + e.getMessage());
        }
    }
}


