package project.hrms.entities.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterForCandidateAuthDto extends AuthDto {
    private String firstName;
    private String lastName;
    private String nationalId;
    private LocalDate dateOfBirth;
    private String passwordConfirm;
}
