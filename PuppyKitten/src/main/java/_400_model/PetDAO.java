package _400_model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _300_model.MapBean;
import _500_model.MemberBean;
import hibernate.util.HibernateUtil;

public class PetDAO implements PetDAO_interface{
	private static final String GET_PET_OWN_ID = "from PetBean where PET_OWN_ID=?";
	public PetBean selectId(int PET_ID) {
		PetBean bean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			bean = (PetBean) session.get(PetBean.class, PET_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return bean;
	}
	@Override
	public List<PetBean> selectPetId(int PET_OWN_ID) {
		List<PetBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_PET_OWN_ID);
			query.setParameter(0, PET_OWN_ID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	
	public PetImgBean selectId2(int PET_ID){
		PetImgBean bean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			bean = (PetImgBean) session.get(PetImgBean.class, PET_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return bean;		
	}
		
	public PetSortCatBean selectSortCat(String PET_SORT_ID){
		PetSortCatBean bean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			bean = (PetSortCatBean) session.get(PetSortCatBean.class, PET_SORT_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return bean;		
		
	}
	
	public PetSortDogBean selectSortDog(String PET_SORT_ID){
		PetSortDogBean bean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			bean = (PetSortDogBean) session.get(PetSortDogBean.class, PET_SORT_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return bean;			
	}
	
	@Override
	public void insert(PetBean bean) {
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
	public void delete(int PET_ID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(PET_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(PetBean bean) {
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

	@Override
	public void insert(PetImgBean bean) {
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
	
}
