package br.fag.edu.locacao.service;

import br.fag.edu.locacao.model.UsuarioModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

@Service("UsuarioService")
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    public UsuarioModel findByNome(String nome) {
        try {
            return entityManager.createQuery("select j from UsuarioModel j where j.nome = :nome", UsuarioModel.class)
                     .setParameter("nome", nome).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (NonUniqueResultException nur) {
            return null;
        }
    }

    public UsuarioModel findByCpf(String cpf) throws Exception {
        try {
            return entityManager.createQuery("select j from UsuarioModel j where j.cpf = :cpf", UsuarioModel.class)
                    .setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (NonUniqueResultException nur) {
            throw new Exception("Mais de um resultado encontrado");
        }
    }
}
