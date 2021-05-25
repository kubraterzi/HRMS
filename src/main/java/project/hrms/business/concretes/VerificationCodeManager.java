package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.VerificationCodeService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.VerificationCodeDao;
import project.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

    private VerificationCodeDao verificationCodeDao;

    @Autowired
    public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }


    @Override
    public Result add(VerificationCode verificationCode) {
        this.verificationCodeDao.save(verificationCode);
        return new SuccessResult("Added.");
    }


}
