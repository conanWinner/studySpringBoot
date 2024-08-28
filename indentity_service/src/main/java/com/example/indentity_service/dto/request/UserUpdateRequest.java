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
public class UserUpdateRequest {

     String firstname;
     String lastname;

    @Size(min = 6, message = "Password must be at least 6 character")
     String password;
     LocalDate dob;


}
