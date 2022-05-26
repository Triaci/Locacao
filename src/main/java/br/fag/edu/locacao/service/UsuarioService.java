package br.fag.edu.locacao.service;

import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.model.UsuarioModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("UsuarioService")
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    public UsuarioModel findByNome(String nome){
        return entityManager.createQuery("select j from" +
                        "UsuarioModel where j.nome = :nome", UsuarioModel.class)
                .setParameter("nome", nome).getSingleResult();
    }

    public UsuarioModel findByCpf(String cpf){
        return entityManager.createQuery("select j from" +
                        "UsuarioModel where j.cpf = :cpf", UsuarioModel.class)
                .setParameter("cpf", cpf).getSingleResult();
    }

}
