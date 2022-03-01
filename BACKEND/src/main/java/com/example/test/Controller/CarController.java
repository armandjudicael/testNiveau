package com.example.test.Controller;

import com.example.test.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {
    @Autowired private JpaRepository<Car,Long> carRepository;
    // GET LIST OF ALL CAR
    @GetMapping("/cars")
    public List<Car> findAll(){
        return carRepository.findAll();
    }
    // GET LIST OF ALL CAR
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> find(@PathVariable long id){
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceAccessException(""));
        return ResponseEntity.ok(car);
    }

    // CREATE A CAR
    @PostMapping("/car")
    public Car createCar(@RequestBody Car car){
     return carRepository.save(car);
    }

    // DELETE ALL CAR
    @DeleteMapping("/cars/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllCars(){
        carRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // DELETE CAR BY ID
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable long id){
       Car car = carRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Car with the "+id+"don't exist"));
       carRepository.delete(car);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // UPDATE CAR BY ID
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id,@RequestBody Car car){
        Car newCar = carRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Car with the "+id+"don't exist"));
        newCar.setName(car.getName());
        newCar.setPhoto(car.getPhoto());
        carRepository.save(newCar);
        return ResponseEntity.ok(newCar);
    }
    @GetMapping("/greeting") public String greeting(){
        return "Hello World! from my Spring Boot REST API";
    }
}


