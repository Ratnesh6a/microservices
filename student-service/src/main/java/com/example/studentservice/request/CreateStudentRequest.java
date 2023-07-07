package com.example.studentservice.request;

import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

@Getter
@Setter
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private long addressId;
}
