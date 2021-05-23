package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public List<Candidate> getAll() {
        return candidateDao.findAll();
    }

    @Override
    public Candidate get(int id) {
        return candidateDao.findById(id).get();
    }

    @Override
    public String add(Candidate candidate) {
        candidateDao.save(candidate);
        return "Added.";
    }

    @Override
    public String delete(Candidate candidate) {
        candidateDao.delete(candidate);
        return "Deleted.";
    }

    @Override
    public String update(Candidate candidate) {
        candidateDao.save(candidate);
        return "Updated.";
    }
}
