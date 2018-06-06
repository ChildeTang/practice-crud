package uni.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import uni.model.User;

import java.util.List;

/**
 * Created by Candy on 2018/6/6
 */
@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> getAll();

    @Insert("INSERT INTO user(`name`, `age`, `email`) VALUES (#{u.name}, #{u.age}, #{u.email})")
    void saveUser(@Param("u") User user);

    @Update("UPDATE user SET `name` = #{u.name}, `age` = #{u.age}, `email` = #{u.email} WHERE `id` = #{u.id}")
    void updateUser(@Param("u") User user);

    @Delete("DELETE FROM user WHERE `id` = #{1}")
    void deleteById(Integer id);
}
