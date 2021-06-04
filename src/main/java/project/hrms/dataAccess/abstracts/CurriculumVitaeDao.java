package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.CurriculumVitae;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

    List<CurriculumVitae> findAllByCandidateId(int candidateId);

}
