package tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if (!findByName(user.name) & user.isAuthenticate) {
           data.add(user);
       }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean logoutUser(User user) {
        if(user.isAuthenticate & !user.isAdmin) {
            return true;
        }
        return false;
    }

}