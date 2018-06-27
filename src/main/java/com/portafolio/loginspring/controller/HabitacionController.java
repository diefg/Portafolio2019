package com.portafolio.loginspring.controller;

import com.portafolio.loginspring.entity.Habitacion;
import com.portafolio.loginspring.entity.request.AddHabitacionRequest;
import com.portafolio.loginspring.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {


    @Autowired
    HabitacionRepository habitacionRepository;

    @GetMapping(value="/todos")
    public List<Habitacion> findAllHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<>();
        habitacionRepository.findAll().forEach(habitaciones::add);
        return habitaciones;
    }

    @PostMapping("/agregar")
    public ResponseEntity<HabitacionController> addHabitacion(@RequestBody AddHabitacionRequest addHabitacionRequest){
        Habitacion habitacion = new Habitacion();
        habitacion.setNombre(addHabitacionRequest.getNombre());
        habitacion.setId(addHabitacionRequest.getId());
        habitacion.setAccesorios(addHabitacionRequest.getAccesorios());
        habitacion.setEstado(addHabitacionRequest.getEstado());
        habitacion.setPrecio(addHabitacionRequest.getPrecio());
        habitacion.setTipoCama(addHabitacionRequest.getTipoCama());

        if (habitacion!=null){
            if (!habitacionRepository.existsById(habitacion.getId())){
                habitacionRepository.save(habitacion);
                return new ResponseEntity<HabitacionController>(HttpStatus.OK);
            }else {
                return new ResponseEntity<HabitacionController>(HttpStatus.CONFLICT);
            }
        }else{
            return new ResponseEntity<HabitacionController>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
