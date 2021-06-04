package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {

    DataResult<List<Education>> getAllEducationsByCandidateId(int candidateId);
    Result addEducation(Education education);
}

