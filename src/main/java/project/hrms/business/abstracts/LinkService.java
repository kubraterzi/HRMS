package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Link;

import java.util.List;

public interface LinkService {

    DataResult<List<Link>> getLinksByCandidateId(int candidateId);
    Result addLink(Link link);

}
