package com.example.studentservice.service;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import com.example.studentservice.request.CreateStudentRequest;
import com.example.studentservice.response.AddressResponse;
import com.example.studentservice.response.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WebClient webClient;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest)
    {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());

        StudentResponse studentResponse = this.modelMapper.map(student, StudentResponse.class);
        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
        return studentResponse;
    }
    public  StudentResponse getById(long id)
    {
        Student studentData = studentRepository.findById(id).get();

        StudentResponse studentResponse = this.modelMapper.map(studentData, StudentResponse.class);
        studentResponse.setAddressResponse(getAddressById(studentData.getAddressId()));
        return  studentResponse;
    }

    public AddressResponse getAddressById(long addressId)
    {
        Mono<AddressResponse> addressResponseMono = webClient.get().uri("/getAddress/" + addressId)
                .retrieve().bodyToMono(AddressResponse.class);
        return addressResponseMono.block();

    }
}
