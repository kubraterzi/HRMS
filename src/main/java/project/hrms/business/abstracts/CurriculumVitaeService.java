package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CurriculumVitae;

import java.util.List;

public interface CurriculumVitaeService {

    DataResult<List<CurriculumVitae>> getCurriculumVitaesByCandidateId(int candidateId);
    Result addCurriculumVitae(CurriculumVitae curriculumVitae);

}
