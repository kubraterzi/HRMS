package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {

    List<ForeignLanguage> findAllByCandidateId(int candidateId);

}
