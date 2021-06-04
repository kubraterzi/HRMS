package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.business.abstracts.CandidateImageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.core.utilities.uploadService.image.cloudinary.CloudinaryService;
import project.hrms.dataAccess.abstracts.CandidateImageDao;
import project.hrms.entities.concretes.CandidateImage;

import java.time.LocalDate;
import java.util.Map;


@Service
public class CandidateImageManager implements CandidateImageService {

    private CloudinaryService cloudinaryService;
    private CandidateImageDao candidateImageDao;

    @Autowired
    public CandidateImageManager(CloudinaryService cloudinaryService, CandidateImageDao candidateImageDao) {
        this.cloudinaryService = cloudinaryService;
        this.candidateImageDao = candidateImageDao;
    }


    @Override
    public Result add(CandidateImage candidateImage, MultipartFile file) {
        Map result = (Map) this.cloudinaryService.savePhoto(file).getData();
        String imageUrl = result.get("url").toString();
        candidateImage.setImageUrl(imageUrl);
        candidateImage.setCreatedAt(LocalDate.now());
        this.candidateImageDao.save(candidateImage);
        return new SuccessResult("Image uploaded.");
    }

    @Override
    public DataResult<CandidateImage> getCandidateImagesByCandidateId(int candidateId) {
        return new SuccessDataResult<CandidateImage>(this.candidateImageDao.findByCandidateId(candidateId));
    }
}
