package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.User;

import java.util.List;


@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public DataResult<User> get(int id) {
        return new SuccessDataResult<User>(this.userDao.findById(id).get());
    }

    @Override
    public Result add(User user) {

        userDao.save(user);
        return new SuccessResult("Added.");
    }


    public DataResult<User> getByMail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email));
    }


    public  Result checkUserExistsByEmail(String email){

        var userEmail = getByMail(email);
        if(userEmail.getData() !=null){
           return new ErrorResult("This email address has been used before.");
        }

        return new SuccessResult();
    }
}
