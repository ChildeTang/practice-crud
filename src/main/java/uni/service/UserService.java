package uni.service;

import uni.model.User;

import java.util.List;

/**
 * Created by Candy on 2018/6/6
 */
public interface UserService {
    List<User> getAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteById(Integer id);
}
