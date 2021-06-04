package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Link;

import java.util.List;

public interface LinkDao extends JpaRepository<Link, Integer> {

    List<Link> findAllByCandidateId(int candidateId);

}
