package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.CargoTripulante.CargoTripulanteDTO;
import com.aerolinea.aerolinea.service.Tripulacion.CargoTripulanteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("CargoTripulante")
public class CargoTripulanteController {

    private final CargoTripulanteService cargoTripulanteService;

    public CargoTripulanteController(CargoTripulanteService cargoTripulanteService){
        this.cargoTripulanteService = cargoTripulanteService;
    }

    @PostMapping("/Create")
    public CargoTripulanteDTO Create(@Valid @RequestBody CargoTripulanteDTO cargoTripulanteDTO) {
        return cargoTripulanteService.create(cargoTripulanteDTO);
    }

    @GetMapping("/GetAll")
    public List<CargoTripulanteDTO> GetAll() {
        return cargoTripulanteService.getAll();
    }

    @PutMapping("/UpdateById/{catId}")
    public void UpdateById(@RequestParam Long catId, @Valid @RequestBody CargoTripulanteDTO cargoTripulanteDTO) {
        cargoTripulanteService.updateById(catId, cargoTripulanteDTO);
    }

    @DeleteMapping("/DeleteById/{catId}")
    public void DeleteById(@RequestParam Long catId) {
        cargoTripulanteService.deleteById(catId);
    }

}
