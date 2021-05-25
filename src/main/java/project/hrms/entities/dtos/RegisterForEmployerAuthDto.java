package project.hrms.entities.dtos;

import lombok.Data;

@Data
public class RegisterForEmployerAuthDto extends AuthDto {

    private String website;
    private String phoneNumber;
    private String companyName;
    private String passwordConfirm;

}
