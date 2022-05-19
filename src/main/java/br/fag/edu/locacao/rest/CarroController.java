package br.fag.edu.locacao.rest;

import br.fag.edu.locacao.model.CarroModel;
import br.fag.edu.locacao.repository.CarroRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> insert(@RequestBody CarroModel carro) {
        if(carro.getModelo() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Modelo Inválido!");

        } else if(carro.getPlaca() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Placa Inválida!");

        } else if(carro.getMarca() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Marca Inválida!");

        } else if (carro.getAno() <= 1885){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ano Inválido!");

        }

        carroRB.saveAndFlush(carro);
        return ResponseEntity.ok().build();
        
    }
    
    @Override
    public ResponseEntity<?> update(CarroModel updateObjeto) {
        CarroModel carro = carroRB.findById(updateObjeto.getId()).get();

        if(updateObjeto.getModelo() == null){
           return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Modelo Inválido!");
        }
        if(updateObjeto.getAno() <= 1885){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ano Inválido!");
        }
        if(updateObjeto.getMarca() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Marca Inválido!");
        }
        if(updateObjeto.getPlaca() == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Placa Inválido!");
        }
        updateObjeto.setAno(carro.getAno());
        updateObjeto.setMarca(carro.getMarca());
        updateObjeto.setModelo(carro.getModelo());
        updateObjeto.setPlaca(carro.getPlaca());

        carroRB.saveAndFlush(updateObjeto);
        return ResponseEntity.ok().build();
    }
}
