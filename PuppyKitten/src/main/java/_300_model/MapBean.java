package _300_model;

public class MapBean {
	private Integer MAP_ID;
	private String MAP_KIND;
	private String MAP_NAME;
	private String MAP_PHONE;
	private String MAP_CITY;
	private String MAP_AREA;
	private String MAP_ADD;
	private String MAP_BODY;

	
	@Override
	public String toString() {
		return MAP_ID+","+MAP_NAME;
	}	
	public Integer getMAP_ID() {
		return MAP_ID;
	}
	public void setMAP_ID(Integer mAP_ID) {
		MAP_ID = mAP_ID;
	}
	public String getMAP_KIND() {
		return MAP_KIND;
	}
	public void setMAP_KIND(String mAP_KIND) {
		MAP_KIND = mAP_KIND;
	}
	public String getMAP_NAME() {
		return MAP_NAME;
	}
	public void setMAP_NAME(String mAP_NAME) {
		MAP_NAME = mAP_NAME;
	}
	public String getMAP_PHONE() {
		return MAP_PHONE;
	}
	public void setMAP_PHONE(String mAP_PHONE) {
		MAP_PHONE = mAP_PHONE;
	}
	public String getMAP_CITY() {
		return MAP_CITY;
	}
	public void setMAP_CITY(String mAP_CITY) {
		MAP_CITY = mAP_CITY;
	}
	public String getMAP_AREA() {
		return MAP_AREA;
	}
	public void setMAP_AREA(String mAP_AREA) {
		MAP_AREA = mAP_AREA;
	}
	public String getMAP_ADD() {
		return MAP_ADD;
	}
	public void setMAP_ADD(String mAP_ADD) {
		MAP_ADD = mAP_ADD;
	}
	public String getMAP_BODY() {
		return MAP_BODY;
	}
	public void setMAP_BODY(String mAP_BODY) {
		MAP_BODY = mAP_BODY;
	}
	
	
	
}
