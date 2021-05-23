package project.hrms.business.abstracts;

import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.User;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    Employer get(int id);
    String add(Employer employer);
    String delete(Employer employer);
    String update(Employer employer);
}
