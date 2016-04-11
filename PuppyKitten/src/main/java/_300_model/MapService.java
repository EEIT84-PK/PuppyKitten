package _300_model;

import java.util.ArrayList;
import java.util.List;


public class MapService {
	private MapDAO_interface dao;

	public MapService() {
		dao = new MapDAO();
	}

	public List<MapBean> select(MapBean bean){
		
		List<MapBean> result = null;
		if(bean==null) {
			result = dao.selectAll(); 
			
		} else {
			MapBean temp = dao.selectId(bean.getMAP_ID());
			if(temp!=null) {
				result = new ArrayList<MapBean>();
				result.add(temp);
				}
		}
		return result;
	}
	
	public List<MapBean> selectMap(MapBean bean) {
		List<MapBean> result = null;
		String kind = bean.getMAP_KIND();
		String city = bean.getMAP_CITY();
		String area = bean.getMAP_AREA();

		if (city.trim().length() == 0 && area.trim().length() == 0) {	
			result = dao.selectMap(kind);
			
		} else if (area.trim().length() == 0) {
			result = dao.selectMap(kind, city);
			
		} else {
			result = dao.selectMap(kind,city,area);
		}
		return result;
	}

	public MapBean insert(MapBean bean){
		dao.insert(bean);
		return bean;
	}
	
	public int delete(int id){
		dao.delete(id);
		return id;
	}
	
	public MapBean update(MapBean bean){
		dao.update(bean);
		return bean;
	}
	
}
