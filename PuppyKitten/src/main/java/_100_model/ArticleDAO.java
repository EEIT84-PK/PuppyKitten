package _100_model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;

public class ArticleDAO implements ArticleDAO_interface {	
	
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
}
