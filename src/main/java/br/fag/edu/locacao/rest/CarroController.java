package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.repository.CarroRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/carro")
public class CarroController extends BaseController<CarroModel>{

    @Autowired
    private CarroRB carroRB;
    @Override
    public List<CarroModel> list() {
        List<CarroModel> carro = carroRB.findAll();
        return  carro;
    }

    public void teste(){}
}
