package com.example.indentity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

     String id;
     String firstname;
     String lastname;

    @Size(min = 3, message = "User_Invalid")
     String username;

    @Size(min = 6, message = "Password_Invalid")
     String password;
     LocalDate dob;
}
