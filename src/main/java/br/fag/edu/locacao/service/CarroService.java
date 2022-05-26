package br.fag.edu.locacao.service;

import br.fag.edu.locacao.model.CarroModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("CarroService")
public class CarroService {

    @PersistenceContext
    private EntityManager entityManager;

    public CarroModel findByModelo(String modelo){
            return entityManager.createQuery("select j from" +
                                       "CarroModel where j.modelo = :modelo", CarroModel.class)
                                        .setParameter("modelo", modelo).getSingleResult();
    }

    public CarroModel findByPlaca(String placa){
        return entityManager.createQuery("select j from" +
                        "CarroModel where j.placa = :placa", CarroModel.class)
                .setParameter("placa", placa).getSingleResult();
    }
}
