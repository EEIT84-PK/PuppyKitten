package _200_model;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
	private ShopDAO_interface dao;
	private List<ShopBean> result;

	public ShopService() {
		dao = new ShopDAO();
	}

	public List<ShopBean> select(ShopBean bean) {
		if (bean.getPRO_ID() == null) {
			result = dao.select_All();
		} else {
			ShopBean temp = dao.selectId(bean.getPRO_ID());
			if (temp != null) {
				result = new ArrayList<ShopBean>();
				result.add(temp);
			}
		}
		return result;
	}

	public List<ShopBean> selectShop(ShopBean bean) {
		List<ShopBean> result = null;
		String animal = bean.getPRO_ANIMAL();
		String kind = bean.getPRO_KIND();
//		System.out.println("animal="+kind);
		if (animal==null||animal.trim().length() == 0) {
			result = dao.select_Product(kind);
			
		} else {
			result = dao.select_Product(animal, kind);
		}
		return result;
	}

	public ShopBean inesrt(ShopBean bean) {
		dao.insert(bean);
		return bean;
	}

	public int delete(int id) {
		dao.delete(id);
		return id;
	}

	public ShopBean update(ShopBean bean) {
		dao.update(bean);
		return bean;
	}
}
