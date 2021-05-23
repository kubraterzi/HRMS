package project.hrms.business.abstracts;

import project.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User get(int id);
    String add(User user);
    String delete(User user);
    String update(User user);

}
