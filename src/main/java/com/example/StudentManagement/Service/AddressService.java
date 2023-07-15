package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Address;
import com.example.StudentManagement.Repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public String addAddress(Address address) {
        if(address!=null) {
            addressRepo.save(address);
            return "address added successfullly.";
        }
        return "address is null.";
    }

    public Iterable<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddress(Long addId) {
        Optional<Address> optionalAddress=addressRepo.findById(addId);
        return optionalAddress.get();
    }

    public String deleteAddress(Long Id) {
        addressRepo.deleteById(Id);
        return "deleted!!";
    }

    public String updateAddress(Address address, Long addId) {
        Optional<Address> optionalAddress = addressRepo.findById(addId);
        if(optionalAddress.isEmpty()){
            return "Address with id "+addId + " is not present";
        }else{
            address.setAddressId(addId);
            addressRepo.save(address);
            return "Address with id "+addId + " updated successfully";
        }
    }
    }

