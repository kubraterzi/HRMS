package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.RegisterForEmployerAuthDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<Employer> get(int id);
    Result add(Employer employer);
    Result delete(Employer employer);
    Result update(Employer employer);
}
