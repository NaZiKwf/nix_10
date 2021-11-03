package ua.com.alevel.Service;

import ua.com.alevel.DAO.UserDAO;
import ua.com.alevel.Entity.User;

public class UserService {

    private final UserDAO userDao = new UserDAO();
    public static User[] findAll() {
        return UserDAO.findAll();
    }

    public void create(User user) {
        userDao.create(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public User findById(String id) {
        return userDao.findById(id);
    }

}
