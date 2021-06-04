package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.ForeignLanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ForeignLanguageDao;
import project.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getForeignLanguagesByCandidateId(int candidateId) {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAllByCandidateId(candidateId));
    }

    @Override
    public Result addForeignLanguage(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult();
    }
}
