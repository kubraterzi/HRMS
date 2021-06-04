package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SkillService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.SkillDao;
import project.hrms.entities.concretes.Skill;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }


    @Override
    public DataResult<List<Skill>> getSkillsByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAllByCandidateId(candidateId));
    }

    @Override
    public Result addSkill(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult();
    }
}
