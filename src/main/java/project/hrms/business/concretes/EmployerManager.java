package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.User;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }


    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }

    @Override
    public Employer get(int id) {
        return employerDao.findById(id).get();
    }

    @Override
    public String add(Employer employer) {
        employerDao.save(employer);
        return "Added.";
    }

    @Override
    public String delete(Employer employer) {
        employerDao.delete(employer);
        return "Deleted.";
    }

    @Override
    public String update(Employer employer) {
        employerDao.save(employer);
        return "Updated.";
    }
}
