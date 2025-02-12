package ai.recruit.testrecruit.dto;

import ai.recruit.testrecruit.enums.Role;

import java.time.LocalDate;

public class UserResponseDto {
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private Role role;
    private Long companyId;
}
