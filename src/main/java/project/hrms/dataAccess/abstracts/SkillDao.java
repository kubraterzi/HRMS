package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillDao extends JpaRepository<Skill, Integer> {

    List<Skill> findAllByCandidateId(int candidateId);

}
