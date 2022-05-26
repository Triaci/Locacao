package br.fag.edu.locacao.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("UsuarioService")
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;
}
