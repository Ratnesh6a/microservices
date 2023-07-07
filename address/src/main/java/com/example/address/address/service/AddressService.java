package com.example.address.address.service;

import com.example.address.address.entity.Address;
import com.example.address.address.repository.AddressRepository;
import com.example.address.address.request.CreateAddressRequest;
import com.example.address.address.response.AddressResponse;
import org.hibernate.type.descriptor.sql.internal.CapacityDependentDdlType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest){
        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());
        Address saveAddress = addressRepository.save(address);
        AddressResponse addressResponse = this.modelMapper.map(saveAddress, AddressResponse.class);

        return addressResponse;
    }

    public AddressResponse getAddressById(long id)
    {
        Address byId = addressRepository.findById(id).get();
        AddressResponse addressResponse = this.modelMapper.map(byId, AddressResponse.class);

        return addressResponse;
    }

}
