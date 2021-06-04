package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CurriculumVitaeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import project.hrms.entities.concretes.CurriculumVitae;

import java.util.List;


@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getCurriculumVitaesByCandidateId(int candidateId) {
        return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAllByCandidateId(candidateId));
    }

    @Override
    public Result addCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult();
    }
}
