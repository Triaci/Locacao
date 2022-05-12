package br.fag.edu.locacao.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class BaseController<T> {

    @GetMapping("/list")
    public abstract List<T> list();
}