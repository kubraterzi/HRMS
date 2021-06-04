package project.hrms.core.utilities.uploadService.image.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadManager implements CloudinaryService{

    private Cloudinary cloudinary;

    @Autowired
    public ImageUploadManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    @Override
    public DataResult<Map> savePhoto(MultipartFile file) { // -> Map = Dictionary -> "image": "url" / "createdAt" : "00.00.0000"
        try {
            Map imageUpload = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()); // cloudinary içerisinde upload class ının upload metodunu kullanarak file ı byte lara ayırdık
            return new SuccessDataResult<Map>(imageUpload);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
    }
}
