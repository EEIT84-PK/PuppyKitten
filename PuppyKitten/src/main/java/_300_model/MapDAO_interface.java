package _300_model;

import java.util.List;



public interface MapDAO_interface {
	
	public List<MapBean> selectAll();
	public List<MapBean> selectMap(String kind,String city,String area);
	public List<MapBean> selectMap(String kind,String city);
	public List<MapBean> selectMap(String kind);
	
	public MapBean selectId(int id);
	public void insert(MapBean bean);
	public void delete(int id);
	public void update(MapBean bean);



}