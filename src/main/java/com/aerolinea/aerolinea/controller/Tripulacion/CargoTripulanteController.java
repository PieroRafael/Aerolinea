package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.CargoTripulante.Request.CargoTripulanteCreateRequestDTO;
import com.aerolinea.aerolinea.dto.CargoTripulante.Request.CargoTripulanteUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.CargoTripulante.Response.CargoTripulanteCreateResponseDTO;
import com.aerolinea.aerolinea.dto.CargoTripulante.Response.CargoTripulanteGetAllResponseDTO;
import com.aerolinea.aerolinea.service.Tripulacion.CargoTripulanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cargoTripulante")
public class CargoTripulanteController {

    private final CargoTripulanteService cargoTripulanteService;

    public CargoTripulanteController(CargoTripulanteService cargoTripulanteService){
        this.cargoTripulanteService = cargoTripulanteService;
    }

    @PostMapping("/create")
    public ResponseEntity<CargoTripulanteCreateResponseDTO> create(@Valid @RequestBody CargoTripulanteCreateRequestDTO cargoTripulanteCreateRequestDTO) {
        CargoTripulanteCreateResponseDTO cargoTripulante = cargoTripulanteService.create(cargoTripulanteCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoTripulante);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CargoTripulanteGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cargoTripulanteService.getAll());
    }

    @PutMapping("/updateById/{catId}")
    public ResponseEntity<Void> updateById(@PathVariable Long catId, @Valid @RequestBody CargoTripulanteUpdateByIdRequestDTO cargoTripulanteUpdateByIdRequestDTO) {
        cargoTripulanteService.updateById(catId, cargoTripulanteUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{catId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long catId) {
        cargoTripulanteService.deleteById(catId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
