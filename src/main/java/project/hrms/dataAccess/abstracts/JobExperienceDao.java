package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> findAllByCandidateIdOrderByDateOfEnd(int candidateId);

}
