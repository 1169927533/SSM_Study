package zjc.java;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zjc.model.User;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisFirst {
    @Test
    public void findUserById() throws IOException {
        //mybatis配置文件
        String respurce = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(respurce);
        //创建会话工厂，传入mybatis的配置文件
        //创建会话工程,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数是:namespace+"."+id
        User user = sqlSession.selectOne("zjc.findUserById",1);
        System.out.println(user.getSex());

        sqlSession.close();
    }

    //模糊查询
    @Test
    public void findUserByName(){
        //mybatis配置文件
        String respurce = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(respurce);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建会话工厂，传入mybatis的配置文件
        //创建会话工程,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数是:namespace+"."+id
        List<User> list = sqlSession.selectList("zjc.findUserByName","余");
        System.out.println(list);

        sqlSession.close();
    }
    //插入数据
    @Test
    public void insertUser(){
        //mybatis配置文件
        String respurce = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(respurce);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建会话工厂，传入mybatis的配置文件
        //创建会话工程,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数是:namespace+"."+id
        User user = new User();
        user.setUsername("孙好");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("杭州");
        sqlSession.insert("zjc.insertUser",user);

        //提交事务
        sqlSession.commit();
        System.out.println(user.getId());
        sqlSession.close();
    }

    //删除用户
    @Test
    public void deleteUser(){
        //mybatis配置文件
        String respurce = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(respurce);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建会话工厂，传入mybatis的配置文件
        //创建会话工程,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数是:namespace+"."+id
         sqlSession.delete("zjc.deletUser",6);
         sqlSession.commit();
        sqlSession.close();
    }

    //更新用户
    @Test
    public void updateUser(){
        //mybatis配置文件
        String respurce = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(respurce);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建会话工厂，传入mybatis的配置文件
        //创建会话工程,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数是:namespace+"."+id
        User user = new User();
        user.setId(3);//更新的时候必须设置id
        user.setUsername("孙好");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("杭州");
        sqlSession.update("zjc.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}





















