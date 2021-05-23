package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobPositionService;
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
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public JobPosition get(int id) {
        return jobPositionDao.findById(id).get();
    }

    @Override
    public String add(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return "Added.";
    }

    @Override
    public String delete(JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
        return "Deleted.";
    }

    @Override
    public String update(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return "Updated.";
    }
}
