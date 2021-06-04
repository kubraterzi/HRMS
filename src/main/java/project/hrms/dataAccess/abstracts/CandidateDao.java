package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.dtos.CandidateResumeDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer> { // Integer -> primary key in veri türü

    Candidate findByNationalId(String nationalId);
}
