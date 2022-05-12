package br.fag.edu.locacao.repository;

import br.fag.edu.locacao.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CarroRB extends JpaRepository<CarroModel, UUID> {

}
