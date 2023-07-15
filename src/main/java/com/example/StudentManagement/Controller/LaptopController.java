package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Laptop;
import com.example.StudentManagement.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @PostMapping("addLaptop")
    public String addLaptop(@RequestBody Laptop laptop){

        return laptopService.addLaptop(laptop);
    }

    @GetMapping("Laptop/{laptopId}")
    public List<Laptop> getAllLaptop(@PathVariable Long laptopId){
        return laptopService.getAllLaptop(laptopId);
    }

    @DeleteMapping("/{laptopId}")
    public String deleteLaptopById(@PathVariable Long laptopId){
        return laptopService.deleteLaptopById(laptopId);
    }

    @PutMapping("/{LaptopId}")
    public String updateLaptop(@PathVariable Long LaptopId , @RequestBody Laptop laptop){
        return laptopService.updateLaptop(LaptopId , laptop);
    }
}
