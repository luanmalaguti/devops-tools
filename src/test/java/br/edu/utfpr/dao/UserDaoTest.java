package br.edu.utfpr.dao;


import br.edu.ufpr.dao.AbstractDAO;
import br.edu.utfpr.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserDaoTest {

    private AbstractDAO<User> dao;
    private User user = null;

    @Before
    public void setUp(){
        dao = new AbstractDAO<User>(User.class);
    }

    @Test
    public void save(){
        user = dao.save(new User("Luan","luanmaladguti@gmail.com","12345"));
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void update(){
        user = dao.find(51L);
        user.setName("Luan [edit]");
        Assert.assertEquals(dao.save(user).getName(),user.getName());
    }


}
