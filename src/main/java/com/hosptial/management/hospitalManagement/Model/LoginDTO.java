package com.hosptial.management.hospitalManagement.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LoginDTO {

    @NonNull
    private String userName;
    @NonNull
    private String password;
}
