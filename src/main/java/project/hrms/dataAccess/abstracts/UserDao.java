package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
