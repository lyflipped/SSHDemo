package com.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;
@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl  implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override

	public User findUserById(Integer id) throws Exception {
		String hql = "from User where id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql)
                    .setParameter(0, id);
        List list = (List) query.list();
        User user = (User)list.get(0);
        return user;
	}

	@Override
	public List<User> findUserList() throws Exception {
		String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<User> list = (List) query.list();
     
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public void deleteUser(Integer id) throws Exception {
		User user=new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
		
	}

	@Override
	public void updateUserName(User user) throws Exception {
	
		sessionFactory.getCurrentSession().update(user);
		
	}

}
