package project.hrms.business.abstracts;

import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

public interface SystemPersonnelService {
    List<SystemPersonnel> getAll();
    SystemPersonnel get(int id);
    String add(SystemPersonnel systemPersonnel);
    String delete(SystemPersonnel systemPersonnel);
    String update(SystemPersonnel systemPersonnel);
}
