package _400_model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PetBean {
	private Integer PET_OWN_ID;
	private Integer PET_ID;
	private String PET_NAME;
	private java.util.Date PET_AGE;
	private Double PET_WEIGHT;
	private String PET_KING;
	private String PET_SORT_ID;
	private String PET_SEX;
	private String PET_BODY;
	
public PetBean() {
		
	}
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	public PetBean(String[] temp) throws IllegalArgumentException {
		if(temp!=null) {
			if(temp.length==9) {
				PET_OWN_ID = Integer.parseInt(temp[0]);
				PET_ID=Integer.parseInt(temp[1]);
				PET_NAME = temp[2];				
				try {
					PET_AGE = sFormat.parse(temp[3].trim());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				PET_WEIGHT = Double.parseDouble(temp[4]);
				PET_KING = temp[5];	
				PET_SORT_ID = temp[6];	
				PET_SEX = temp[7];	
				PET_BODY = temp[8];	
			} else {
				throw new IllegalArgumentException("argument length error "+ temp.length);
			}
		}
	}
	
	@Override
	public String toString() {
		return "_400_model.PetBean["+ PET_OWN_ID+ ","+ PET_ID+ ","+ PET_NAME+ ","+ PET_AGE+ ","+ PET_WEIGHT+ ","+ PET_KING+ ","+ PET_SORT_ID+ ","+ PET_SEX+ ","+ PET_BODY+ "]";
	}
	public Integer getPET_OWN_ID() {
		return PET_OWN_ID;
	}
	public void setPET_OWN_ID(Integer pET_OWN_ID) {
		PET_OWN_ID = pET_OWN_ID;
	}
	
	public Integer getPET_ID() {
		return PET_ID;
	}
	public void setPET_ID(Integer pET_ID) {
		PET_ID = pET_ID;
	}
	public String getPET_NAME() {
		return PET_NAME;
	}
	public void setPET_NAME(String pET_NAME) {
		PET_NAME = pET_NAME;
	}
	public java.util.Date getPET_AGE() {
		return PET_AGE;
	}
	public void setPET_AGE(java.util.Date pET_AGE) {
		PET_AGE = pET_AGE;
	}

	public Double getPET_WEIGHT() {
		return PET_WEIGHT;
	}
	public void setPET_WEIGHT(Double pET_WEIGHT) {
		PET_WEIGHT = pET_WEIGHT;
	}
	public String getPET_KING() {
		return PET_KING;
	}
	public void setPET_KING(String pET_KING) {
		PET_KING = pET_KING;
	}
	public String getPET_SORT_ID() {
		return PET_SORT_ID;
	}
	public void setPET_SORT_ID(String pET_SORT_ID) {
		PET_SORT_ID = pET_SORT_ID;
	}
	public String getPET_SEX() {
		return PET_SEX;
	}
	public void setPET_SEX(String pET_SEX) {
		PET_SEX = pET_SEX;
	}
	public String getPET_BODY() {
		return PET_BODY;
	}
	public void setPET_BODY(String pET_BODY) {
		PET_BODY = pET_BODY;
	}
	
}
