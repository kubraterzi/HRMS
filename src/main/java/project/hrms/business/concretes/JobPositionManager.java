package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobPositionService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobPositionDao;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>> (this.jobPositionDao.findAll());
    }

    @Override
    public DataResult<JobPosition> getByJobTitle(String jobTitle) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobTitle(jobTitle));
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.findById(id).get());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = getByJobTitle(jobPosition.getJobTitle());
        if (result != null) {
            return new ErrorResult("Job Position exists.");
        }

        return new SuccessResult("Added.");
    }

    @Override
    public Result delete(JobPosition jobPosition){
        jobPositionDao.delete(jobPosition);
        return new SuccessResult("Deleted.");
    }

    @Override
    public Result update(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Updated.");
    }
}
