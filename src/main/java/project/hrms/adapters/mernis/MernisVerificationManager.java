package project.hrms.adapters.mernis;

import org.springframework.stereotype.Service;
import project.hrms.core.utilities.business.BusinessRules;
import project.hrms.core.utilities.results.*;
import project.hrms.entities.concretes.Candidate;

import java.time.LocalDate;

@Service
public class MernisVerificationManager implements MernisVerificationService {

    @Override
    public Result checkIfRealPerson(Candidate candidate) {
        var result = BusinessRules.run(checkNationalId(candidate.getNationalId()),checkFirstName(candidate.getFirstName()),
                checkLastName(candidate.getLastName()), checkBirthOfDate(candidate.getDateOfBirth()));
        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        return new SuccessResult();
    }


    private Result checkNationalId(String nationalId){

        if(nationalId ==null){
            return new ErrorResult("Field National Id cannot be blank ");
        }

        if (nationalId.length() != 11){
            return new ErrorResult("National identity must consist of 11 characters.");
        }

        return new SuccessResult("National Id is validated.");

    }

    private Result checkFirstName(String firstName){

        if(firstName ==null){
            return new ErrorResult("Field First Name cannot be blank ");
        }

        if (firstName.length() <2){
            return new ErrorResult("The First Name must consist of a minimum of 2 characters.");
        }

        return new SuccessResult("First Name is validated.");
    }

    private Result checkLastName(String lastName){

        if(lastName ==null){
            return new ErrorResult("Field Last Name cannot be blank ");
        }

        if (lastName.length() <2){
            return new ErrorResult("The Last Name must consist of a minimum of 2 characters.");
        }

        return new SuccessResult("Last Name is validated.");
    }

    private Result checkBirthOfDate(LocalDate birthOfDate){

        if(birthOfDate ==null){
            return new ErrorResult("Field Birth of Date cannot be blank ");
        }

        if (birthOfDate.isAfter(LocalDate.now())){
            return new ErrorResult("Date of Birth must be before today");
        }

        return new SuccessResult("Birth of date validated.");
    }
}