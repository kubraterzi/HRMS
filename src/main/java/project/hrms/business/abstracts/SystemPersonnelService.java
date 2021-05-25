package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

public interface SystemPersonnelService {
    DataResult<List<SystemPersonnel>> getAll();
    DataResult<SystemPersonnel> get(int id);
    Result add(SystemPersonnel systemPersonnel);
    Result delete(SystemPersonnel systemPersonnel);
    Result update(SystemPersonnel systemPersonnel);
}
