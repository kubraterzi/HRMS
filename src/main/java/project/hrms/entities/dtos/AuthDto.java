package project.hrms.entities.dtos;

import lombok.Data;
import project.hrms.entities.abstracts.Dto;

@Data
public class AuthDto implements Dto {

    private String email;
    private String password;

}
