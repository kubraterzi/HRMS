package project.hrms.business.abstracts;

import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
    JobPosition get(int id);
    String add(JobPosition jobPosition);
    String delete(JobPosition jobPosition);
    String update(JobPosition jobPosition);
}
