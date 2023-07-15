package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Address;
import com.example.StudentManagement.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("saveAddress")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @GetMapping("getAddress/{addId}")
    public Address getAddress(@PathVariable Long addId){
        return addressService.getAddress(addId);
    }
    @DeleteMapping("deleteAddress/{Id}")
    public String deleteAddress(@PathVariable Long Id){
        return addressService.deleteAddress(Id);
    }
    @PutMapping("updateAddress/{addId}")
    public String updateAddress(@RequestBody Address address,@PathVariable Long addId){
        return addressService.updateAddress(address,addId);
    }

}
