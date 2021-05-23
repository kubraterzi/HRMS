package project.hrms.business.abstracts;

import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.User;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAll();
    Candidate get(int id);
    String add(Candidate candidate);
    String delete(Candidate candidate);
    String update(Candidate candidate);
}
