package _500_model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;

public class MemberDAO implements MemberDAO_interface {
	private static final String GET_BY_ACCOUNT = "from MemberBean where MEM_ACCOUNT=?";

	@Override
	public void insert(MemberBean bean) {
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
	public List<MemberBean> select(String account) {
		List<MemberBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_ACCOUNT);
			query.setParameter(0, account);
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
	public MemberBean selectMemberByAccount(String account) {
		MemberBean memberBean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from MemberBean where MEM_ACCOUNT=:account");

		try {
			if (account != null && !account.isEmpty()) {
				query.setParameter("account", account);
				List<MemberBean> list = query.list();
				memberBean = list.get(0);

			}
		} catch (Exception e) {
		
		}

		return memberBean;

	}

	@Override
	public void update(MemberBean bean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(bean);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().begin();
			throw e;
		}

	}

	@Override
	public MemberBean selectMemberByMemId(final Integer memberId) {
		MemberBean memberBean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from MemberBean where MEM_ID:memberId");
		List<MemberBean> list = query.list();
		if (memberId != null) {
			memberBean = list.get(0);
		}
		return memberBean;
	}

}
