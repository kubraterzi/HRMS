package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.business.abstracts.CandidateImageService;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.CandidateImage;

@RestController
@RequestMapping("/api/candidateimages/")
public class CandidateImagesController {

    private CandidateImageService candidateImageService;

    @Autowired
    public CandidateImagesController(CandidateImageService candidateImageService) {
        this.candidateImageService = candidateImageService;
    }

    @GetMapping("getImageByCandidateId")
    public ResponseEntity<?> getImageByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.candidateImageService.getCandidateImagesByCandidateId(candidateId));
    }


    @PostMapping("addCandidateImage")
    public ResponseEntity<?> addCandidateImage(@RequestBody MultipartFile file, @RequestParam int candidateId){
        Candidate candidate = new Candidate(); // dışarıdan doğrudan candidate alamazdık, input tan dosya eklediğimizde doğrudan RequestBody içerisindeki imageUrl alanına yazdıramazdık.
        CandidateImage candidateImage = new CandidateImage();

        candidate.setId(candidateId);
        candidateImage.setCandidate(candidate);

        return ResponseEntity.ok(this.candidateImageService.add(candidateImage, file));
    }

}
