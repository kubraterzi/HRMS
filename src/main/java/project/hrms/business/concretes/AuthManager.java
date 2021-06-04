package project.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.*;
import project.hrms.core.utilities.business.BusinessRules;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.core.utilities.verification.VerificationService;
import project.hrms.entities.dtos.AuthDto;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.User;
import project.hrms.entities.concretes.VerificationCode;
import project.hrms.entities.dtos.LoginUserAuthDto;
import project.hrms.entities.dtos.RegisterForCandidateAuthDto;
import project.hrms.entities.dtos.RegisterForEmployerAuthDto;

@Service
public class AuthManager implements AuthService {

    private ModelMapper modelMapper;
    private UserService userService;
    private CandidateService candidateService;
    private EmployerService employerService;
    private VerificationService verificationService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public AuthManager(ModelMapper modelMapper, UserService userService, CandidateService candidateService,VerificationCodeService verificationCodeService,
                       VerificationService verificationService, EmployerService employerService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.candidateService = candidateService;
        this.verificationService = verificationService;
        this.employerService= employerService;
        this.verificationCodeService = verificationCodeService;
    }


    @Override
    public Result login(LoginUserAuthDto loginUserDto) {
        return new SuccessResult("User successfully logged in.");
    }

    @Override
    public Result registerForEmployer(RegisterForEmployerAuthDto registerForEmployerDto) {

        var result = BusinessRules.run(checkPasswordConfirm(registerForEmployerDto.getPassword(), registerForEmployerDto.getPasswordConfirm()),
                checkNullFields(registerForEmployerDto), this.userService.checkUserExistsByEmail(registerForEmployerDto.getEmail()));

        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        Employer employerInfo= modelMapper.map(registerForEmployerDto, Employer.class);

        this.employerService.add(employerInfo);
        this.verifyAccount(registerForEmployerDto);
        return new SuccessResult("Employer is successfully registered.");

    }

    @Override
    public Result registerForCandidate(RegisterForCandidateAuthDto registerForCandidateDto) {

        if (registerForCandidateDto.getEmail() ==null || registerForCandidateDto.getPassword() == null || registerForCandidateDto.getPasswordConfirm() == null){
            return new ErrorResult("Fields cannot be blank ");
        }
        var checkUserEntry =  BusinessRules.run(checkPasswordConfirm(registerForCandidateDto.getPassword(), registerForCandidateDto.getPasswordConfirm()),
                this.userService.checkUserExistsByEmail(registerForCandidateDto.getEmail()));
        if (!checkUserEntry.isSuccess()){
            return new ErrorResult(checkUserEntry.getMessage());
        }

//        Candidate candidateInfo = modelMapper.map(registerForCandidateDto, Candidate.class);
//        this.candidateService.add(candidateInfo); -> nationalId int e çevirmeye çalışıp hata veriyor.

        this.candidateService.add(new Candidate(registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword(),
                registerForCandidateDto.getFirstName(),registerForCandidateDto.getLastName(), registerForCandidateDto.getNationalId(),
                registerForCandidateDto.getDateOfBirth()));

        this.verifyAccount(registerForCandidateDto);
        return new SuccessResult("Candidate is successfully registered.");


    }


    private Result checkPasswordConfirm(String password, String passwordConfirm){

        if (!password.equals(passwordConfirm)){
            return new ErrorResult("Passwords do not match.");
        }

        return new SuccessResult();
    }

    private  Result checkNullFields(RegisterForEmployerAuthDto registerForEmployerDto){

        if(registerForEmployerDto.getPassword() == null){
            return new ErrorResult("Field Password cannot be blank.");
        }

        if(registerForEmployerDto.getPasswordConfirm() == null){
            return new ErrorResult("Field Password Confirm cannot be blank.");
        }

        return new SuccessResult();
    }

    private Result verifyAccount(AuthDto authDto){
        this.verificationService.verificateWithVerificationLink(authDto.getEmail());
        String verificationCode = verificationService.verificateWithVerificationCode();
        User user=this.userService.getByMail(authDto.getEmail()).getData();
        this.verificationCodeService.add(new VerificationCode(user.getId(), verificationCode, true, false));
        return new SuccessResult();
    }
}
