package br.fag.edu.locacao.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("LocacaoService")
public class LocacaoService {

    @PersistenceContext
    private EntityManager entityManager;
}
