package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.dtos.LoginUserAuthDto;
import project.hrms.entities.dtos.RegisterForCandidateAuthDto;
import project.hrms.entities.dtos.RegisterForEmployerAuthDto;

public interface AuthService {

    Result login(LoginUserAuthDto loginUserDto);
    Result registerForEmployer(RegisterForEmployerAuthDto registerForEmployerDto);
    Result registerForCandidate(RegisterForCandidateAuthDto registerForEmployerDto);
}
