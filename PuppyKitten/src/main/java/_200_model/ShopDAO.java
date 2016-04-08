package _200_model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _300_model.MapBean;
import hibernate.util.HibernateUtil;

public class ShopDAO implements ShopDAO_interface {
	private static final String SELECT_ALL = "from ShopBean order by PRO_ID";
	private static final String SELECT_TWO_STMT = "from ShopBean where PRO_ANIMAL=? and PRO_KIND=? order by PRO_ID";
	private static final String SELECT_ONE_STMT = "from ShopBean where PRO_ANIMAL=? order by PRO_ID";

	@Override
	@SuppressWarnings("unchecked")
	public List<ShopBean> select_All() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ShopBean> list;
		try {
			session.beginTransaction();
			list = session.createQuery(SELECT_ALL).list();
//			Query query = session.createQuery(SELECT_ALL);
//			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShopBean> select_Product(String animal, String kind) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ShopBean> list;
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_TWO_STMT);
			query.setParameter(0, animal);
			query.setParameter(1, kind);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShopBean> select_Product(String animal) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ShopBean> list;
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ONE_STMT);
			query.setParameter(0, animal);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public ShopBean selectId(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ShopBean shopbean = null;
		try {
			session.beginTransaction();
			shopbean = (ShopBean) session.get(ShopBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
		}
		return shopbean;
	}

	@Override
	public void insert(ShopBean bean) {
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

	@Override
	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ShopBean bean = session.get(ShopBean.class, id);
			if (bean != null) {
				session.delete(bean);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ShopBean bean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(bean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
}
