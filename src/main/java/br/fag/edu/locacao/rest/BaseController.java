package br.fag.edu.locacao.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public abstract class BaseController<T> {

    @GetMapping("/list")
    public abstract List<T> list();

    @GetMapping("/find")
    public  abstract T find(@RequestParam String id);

    @PostMapping("/insert")
    public abstract void insert(@RequestBody T insertObjeto) throws Exception;

    @PostMapping("/update")
    public abstract void update(@RequestBody T updateObjeto) throws Exception;

}