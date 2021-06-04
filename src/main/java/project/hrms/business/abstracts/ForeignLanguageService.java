package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {

    DataResult<List<ForeignLanguage>> getForeignLanguagesByCandidateId(int candidateId);
    Result addForeignLanguage(ForeignLanguage foreignLanguage);

}
