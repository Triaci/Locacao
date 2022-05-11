package br.fag.edu.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;

public interface LocacaoRB extends JpaRepository<Time, Long> {
}
