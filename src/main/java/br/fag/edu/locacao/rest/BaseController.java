package br.fag.edu.locacao.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.List;

public abstract class BaseController<T> {

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public abstract List<T> list();

    @GetMapping("/find")
    public  abstract T find(@RequestParam String id);

    @PostMapping("/insert")
    public abstract ResponseEntity<?> insert(@RequestBody T insertObjeto);

    @PostMapping("/update")
    public abstract ResponseEntity<?> update(@RequestBody T updateObjeto);

    @GetMapping("/delete")
    public abstract ResponseEntity<?> delete(@RequestParam String id);
}