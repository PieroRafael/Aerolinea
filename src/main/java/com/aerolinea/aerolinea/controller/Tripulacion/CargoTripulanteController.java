package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.CargoTripulante.CargoTripulanteDTO;
import com.aerolinea.aerolinea.service.Tripulacion.CargoTripulanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CargoTripulanteDTO >Create(@Valid @RequestBody CargoTripulanteDTO cargoTripulanteDTO) {
        CargoTripulanteDTO cargoTripulante = cargoTripulanteService.create(cargoTripulanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Cargo Tripulante creado correctamente")
                .body(cargoTripulante);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<CargoTripulanteDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cargoTripulanteService.getAll());
    }

    @PutMapping("/UpdateById/{catId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long catId, @Valid @RequestBody CargoTripulanteDTO cargoTripulanteDTO) {
        cargoTripulanteService.updateById(catId, cargoTripulanteDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{catId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long catId) {
        cargoTripulanteService.deleteById(catId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
