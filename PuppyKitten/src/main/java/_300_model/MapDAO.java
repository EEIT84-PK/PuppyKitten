package _300_model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;


public class MapDAO implements MapDAO_interface {
	private static final String GET_ALL = "from MapBean order by MAP_ID";
	private static final String GET_THREE_STMT = "from MapBean where MAP_KIND=? and MAP_CITY=? and MAP_AREA=? order by MAP_ID";
	private static final String GET_TWO_STMT = "from MapBean where MAP_KIND=? and MAP_CITY=? order by MAP_ID";
	private static final String GET_ONE_STMT = "from MapBean where MAP_KIND=?order by MAP_ID";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapBean> selectAll() {
		List<MapBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapBean> selectMap(String kind,String city,String area) {
		List<MapBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_THREE_STMT);
			query.setParameter(0, kind);
			query.setParameter(1, city);
			query.setParameter(2, area);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MapBean> selectMap(String kind, String city) {
		List<MapBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_TWO_STMT);
			query.setParameter(0, kind);
			query.setParameter(1, city);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MapBean> selectMap(String kind) {
		List<MapBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ONE_STMT);
			query.setParameter(0, kind);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	
	@Override
	public MapBean selectId(int MAP_ID) {
		MapBean mapbean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			mapbean = (MapBean) session.get(MapBean.class, MAP_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return mapbean;
	}
	@Override
	public void insert(MapBean bean) {
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
	public void delete(int MAP_ID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MapBean bean = null;
			bean=(MapBean) session.get(MapBean.class, MAP_ID);
			if(bean!=null){
			session.delete(bean);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
	}
	@Override
	public void update(MapBean bean) {
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
