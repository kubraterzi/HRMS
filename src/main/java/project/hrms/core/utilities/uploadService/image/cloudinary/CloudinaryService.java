package project.hrms.core.utilities.uploadService.image.cloudinary;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

    DataResult<?> savePhoto(MultipartFile file);

}
