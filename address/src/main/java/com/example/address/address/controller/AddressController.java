package com.example.address.address.controller;


import com.example.address.address.request.CreateAddressRequest;
import com.example.address.address.response.AddressResponse;
import com.example.address.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getAddress/{id}")
    public AddressResponse getById(@PathVariable long id)
    {
        return addressService.getAddressById(id);
    }
}
