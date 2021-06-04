package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.CandidateImage;

import java.util.List;

public interface CandidateImageDao extends JpaRepository<CandidateImage,Integer> {

    CandidateImage findByCandidateId(int candidateId);

}
