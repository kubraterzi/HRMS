package project.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {

    DataResult<CandidateImage> getCandidateImagesByCandidateId(int candidateId);
    Result add(CandidateImage candidateImage, MultipartFile file);

}
