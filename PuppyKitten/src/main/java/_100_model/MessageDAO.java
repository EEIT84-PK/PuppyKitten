package _100_model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class MessageDAO implements MessageDAO_interface{	
	private static final String GET_BY_ID = "from MessageBean where MSG_ART_ID=?";
	@Override
	public void insert(MessageBean bean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(bean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageBean> selectId(String id) {
		List<MessageBean> list=null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			list=new ArrayList();
			session.beginTransaction();
			Query querys =  session.createQuery(GET_BY_ID);
			querys.setParameter(0, id);
			list = querys.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

}
