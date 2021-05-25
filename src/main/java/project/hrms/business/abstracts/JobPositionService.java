package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> getByJobTitle(String jobTitle);
    DataResult<JobPosition> getById(int id);
    Result add(JobPosition jobPosition);
    Result delete(JobPosition jobPosition);
    Result update(JobPosition jobPosition);
}
