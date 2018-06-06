package uni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.mapper.UserMapper;
import uni.model.User;
import uni.service.UserService;

import java.util.List;

/**
 * Created by Candy on 2018/6/6
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
