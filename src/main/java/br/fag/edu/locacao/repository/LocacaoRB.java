package br.fag.edu.locacao.repository;

import br.fag.edu.locacao.LocacaoApplication;
import br.fag.edu.locacao.model.LocacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.UUID;

public interface LocacaoRB extends JpaRepository<LocacaoModel, UUID> {
}
