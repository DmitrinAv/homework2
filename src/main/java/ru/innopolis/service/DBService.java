package ru.innopolis.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dao.UserDaoImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *  Service for EntityManagerFactory and staff
 */

@Service
public class DBService implements InitializingBean, DisposableBean {

    private UserDaoImpl userDao;

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Autowired
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void destroy() throws Exception {
        entityManagerFactory.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("pos");
    }

}
