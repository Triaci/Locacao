package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/carro")
public class CarroController extends BaseController<CarroModel>{

    @Override
    public List<CarroModel> list() {
        return new ArrayList<>();
    }
}
