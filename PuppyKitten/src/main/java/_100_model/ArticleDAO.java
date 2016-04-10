package _100_model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;

public class ArticleDAO implements ArticleDAO_interface {	
	private static final String GET_BY_TITLE = "from ArticleBean where ART_TITLE=?";
	private static final String GET_SORT = "from ArticleBean order by ART_HOT desc";
	@Override
	@SuppressWarnings("unchecked")
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean");
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
	public List<ArticleBean> selectAllHot() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean order by ART_HOT desc");
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
	public List<ArticleBean> selectAllTime() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean order by ART_TIME desc");
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
	public List<ArticleBean> selectAllKind() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean order by ART_KIND");
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
	public List<ArticleBean> selectSort() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_SORT);
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
	public List<ArticleBean> selectPost() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean Where ART_KIND='公告'");
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
	public List<ArticleBean> selectActivity() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean Where ART_KIND='活動'");
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
	public List<ArticleBean> selectReviews() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean Where ART_KIND='心得'");
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
	public List<ArticleBean> selectQuestion() {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ArticleBean Where ART_KIND='問題'");
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
	public List<ArticleBean> selectByTitle(String title) {
		List<ArticleBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query =  session.createQuery(GET_BY_TITLE);
			query.setParameter(0, title);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	@Override
	public void insert(ArticleBean bean) {
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
	public void delete(int ART_ID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ArticleBean bean = null;
			bean=(ArticleBean) session.get(ArticleBean.class, ART_ID);
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
	public void update(ArticleBean bean) {
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
