package top.luyuni.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.luyuni.mybatis.dao.UserMapper;
import top.luyuni.mybatis.pojo.User;

import java.io.InputStream;

/**
 * @author ：sean
 * @date ：Created in 2020/6/28
 * @description ：
 * @version: 1.0
 */
public class MybatisApp {
  public static void main(String args[]) throws Exception{
    // 读取配置文件
    InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
    // 构建SqlSessionFactory
    SqlSessionFactory sqlSessionFactory
      = new SqlSessionFactoryBuilder().build(inputStream);

    // dao层使用Mybatis的动态代理，获取mapper
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 获得UserMapper代理对象 (UserMapper两种方式（基于注解映射、基于XML映射)
    UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
    System.out.println("第1次查询");
    User user2 = userMapper2.findByName("Jone");
    System.out.println(user2.getEmail());
    System.out.println("第2次查询");
    User user3 = userMapper2.findByName("Jone");
    System.out.println(user3.getEmail());
    sqlSession.close();
  }
}
