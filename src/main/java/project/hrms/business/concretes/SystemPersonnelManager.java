package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SystemPersonnelService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.SystemPersonnelDao;
import project.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
        this.systemPersonnelDao = systemPersonnelDao;
    }

    @Override
    public DataResult<List<SystemPersonnel>> getAll() {
        return new SuccessDataResult<List<SystemPersonnel>>(systemPersonnelDao.findAll());
    }

    @Override
    public DataResult<SystemPersonnel> get(int id) {
        return new SuccessDataResult<SystemPersonnel>(systemPersonnelDao.findById(id).get());
    }

    @Override
    public Result add(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult("Added.");
    }

    @Override
    public Result delete(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.delete(systemPersonnel);
        return new SuccessResult("Deleted.");
    }

    @Override
    public Result update(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult("Updated.");
    }
}
