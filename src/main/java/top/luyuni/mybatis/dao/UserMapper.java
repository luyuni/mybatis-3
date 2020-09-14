package top.luyuni.mybatis.dao;



import top.luyuni.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
	/**
	 * 根据用户名获取用户信息
	 * @param name 用户名
	 * @return
	 */
  //@Select("SELECT * FROM user WHERE name = #{name}")
  User findByName(String name);

  /**
   * 获取所有用户信息
   * @return
   */
  //@Select("SELECT * FROM user")
  List<User> findAllUsers();

}

