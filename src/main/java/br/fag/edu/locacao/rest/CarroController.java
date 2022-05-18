package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.repository.CarroRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public CarroModel find(String id) {
        return carroRB.getById(UUID.fromString(id));
    }

    @Override
    public void insert(@RequestBody CarroModel carro) throws Exception {
        if(carro.getModelo() == null){
            throw new Exception("Modelo inválido!");
        }

        carroRB.saveAndFlush(carro);
        
    }

    @Override
    public void update(CarroModel updateObjeto) throws Exception {
        if(updateObjeto.getModelo() == null){
            throw new Exception("Modelo Inválido!");
        }
        if(updateObjeto.getAno() <= 1885){
            throw new Exception("Ano Inválido!");
        }
        if(updateObjeto.getMarca() == null){
            throw new Exception("Marca Inválida!");
        }
        if(updateObjeto.getPlaca() == null){
            throw new Exception("Placa Inválida!");
        }
    }
}
