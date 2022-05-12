package br.fag.edu.locacao.repository;

import br.fag.edu.locacao.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UsuarioRB  extends JpaRepository<UsuarioModel, UUID> {

}
