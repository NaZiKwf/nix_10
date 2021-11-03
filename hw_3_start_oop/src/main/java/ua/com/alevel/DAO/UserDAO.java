package ua.com.alevel.DAO;

import ua.com.alevel.DB.DBUser;
import ua.com.alevel.Entity.User;

public class UserDAO {
    public void create(User user) {
        DBUser.getInstance().create(user);
    }

    public void update(User user) {
        DBUser.getInstance().update(user);
    }

    public void delete(String id) {
        DBUser.getInstance().delete(id);
    }

    public User findById(String id) {
        return DBUser.getInstance().findById(id);
    }

    public static User[] findAll() {
        return DBUser.getInstance().findAll();
    }


}
