package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {

    DataResult<List<Skill>> getSkillsByCandidateId(int candidateId);
    Result addSkill(Skill skill);

}
