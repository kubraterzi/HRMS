package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<User> get(int id);
    Result add(User user);
    DataResult<User> getByMail(String email);
    Result checkUserExistsByEmail(String email);

}
