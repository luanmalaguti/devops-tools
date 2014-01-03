package br.edu.utfpr.dao;

import br.edu.ufpr.dao.GenericDAO;
import br.edu.utfpr.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserDaoTest{

    private GenericDAO<User> dao;
    private User user = null;

    @Before
    public void setUp(){
        dao = new GenericDAO<User>(User.class);
    }

    @Test
    public void save(){
        //user = dao.save(new User("Fulano","Fulano@gmail.com","12345"));
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void update(){
        user = dao.save(new User("Fulano", "Fulano@gmail.com", "12345"));
        user.setName("Fulano [edit]");
        Assert.assertEquals(dao.save(user).getName(),"Fulano [edit]");
    }

    @Test
    public void delete(){
        user = dao.save(new User("Fulano","fulano@gmail.com","12345"));
        dao.delete(user);
        Assert.assertNull(dao.find(user.getId()));
    }

    @Test
    public void list(){
        save();
        Assert.assertFalse(dao.list().isEmpty());
    }

    @Test
    public void find(){
        user = dao.save(new User("Fulano","fulano@gmail.com","12345"));
        Assert.assertNotNull(dao.find(user.getId()));
    }
}

