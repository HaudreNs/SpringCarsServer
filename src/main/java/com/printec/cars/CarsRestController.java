package com.printec.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpMethodConstraint;
import java.util.List;

@RestController
public class CarsRestController {


    @Autowired
    CarService carService;
    @GetMapping(value = "/cars")
    public List<Car> doGetCars() {


        return carService.loadAllCars();
    }

    @GetMapping("/car/findById/{id}")
    public Car doGetCarById(@PathVariable("id") int productId)
    {
    
        return carService.loadCarById(productId);
    }

    @GetMapping("/car/findByBrand/{brand}")
    public Car doGetCarById(@PathVariable("brand") String brand)
    {

        return carService.loadCarByBrand(brand);
    }

    @GetMapping("/addCar")
    public boolean doAddCar(@RequestBody Car car)
    {
        return CarService.addCar(car);
    }

    @GetMapping("/removeCar/id/{id}")
    public boolean doDeleteCar(@PathVariable("id") int id)
    {
        return CarService.deleteCar(id);
    }

}
