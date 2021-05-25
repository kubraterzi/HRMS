package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.business.BusinessRules;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.RegisterForEmployerAuthDto;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public DataResult<Employer> get(int id) {
        return new SuccessDataResult<Employer>(employerDao.findById(id).get());
    }

    @Override
    public Result add(Employer employer) {
        var result = BusinessRules.run(checkNullFields(employer), checkEmailIsCompatibleWithDomain(employer));
        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        employerDao.save(employer);
        return new SuccessResult("Added.");
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccessResult("Deleted.");
    }

    @Override
    public Result update(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult("Updated.");
    }

    private Result checkEmailIsCompatibleWithDomain(Employer employer){

        String[] isEmailCompatible = employer.getEmail().split("@", 2); // @ işaretinden iki ayrı parçaya böler
        String webSite = employer.getWebsite().substring(4); // www. kısmından sonrasını alır

        if (!isEmailCompatible[1].equals(webSite)){
            return new ErrorResult("Your Email adress is not compatible with your Web Site domain.");
        }

        return new SuccessResult();
    }

    private  Result checkNullFields(Employer employer){
        if(employer.getWebsite() == null){
            return new ErrorResult("Field Web Site cannot be blank.");
        }

        if(employer.getCompanyName() == null){
            return new ErrorResult("Field Company Name cannot be blank.");
        }

        if(employer.getEmail() == null){
            return new ErrorResult("Field Email cannot be blank.");
        }

        if(employer.getPhoneNumber() == null){
            return new ErrorResult("Field Phone Number cannot be blank.");
        }

        return new SuccessResult();
    }
}
