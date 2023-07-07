package com.example.studentservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private  AddressResponse addressResponse;
}
