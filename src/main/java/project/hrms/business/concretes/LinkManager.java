package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.LinkService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.LinkDao;
import project.hrms.entities.concretes.Link;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public DataResult<List<Link>> getLinksByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Link>>(this.linkDao.findAllByCandidateId(candidateId));
    }

    @Override
    public Result addLink(Link link) {
        this.linkDao.save(link);
        return new SuccessResult();
    }
}
