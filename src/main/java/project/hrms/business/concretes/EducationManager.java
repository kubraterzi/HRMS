package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EducationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EducationDao;
import project.hrms.entities.concretes.Education;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }


    @Override
    public DataResult<List<Education>> getAllEducationsByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCandidateIdOrderByDateOfGraduation(candidateId));
    }

    @Override
    public Result addEducation(Education education) {
        this.educationDao.save(education);
        return new SuccessResult();
    }
}
