package _200_model;

import java.util.List;

public interface ShopDAO_interface {

	List<ShopBean> select_All();

	List<ShopBean> select_Product(String animal, String kind);

	List<ShopBean> select_Product(String animal);

	ShopBean selectId(int id);

	void insert(ShopBean bean);

	void delete(int id);

	void update(ShopBean bean);

}