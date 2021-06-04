package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> findAllByCandidateIdOrderByDateOfGraduation(int candidateId);

}
