package _400_model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PetRelationBean implements Serializable{
	private String INT_MENID_MYSELF;
	private String INT_MENID_LIKE;
	private String INT_STATUS;	
	
	public String getINT_MENID_MYSELF() {
		return INT_MENID_MYSELF;
	}
	public void setINT_MENID_MYSELF(String iNT_MENID_MYSELF) {
		INT_MENID_MYSELF = iNT_MENID_MYSELF;
	}
	public String getINT_MENID_LIKE() {
		return INT_MENID_LIKE;
	}
	public void setINT_MENID_LIKE(String iNT_MENID_LIKE) {
		INT_MENID_LIKE = iNT_MENID_LIKE;
	}
	public String getINT_STATUS() {
		return INT_STATUS;
	}
	public void setINT_STATUS(String iNT_STATUS) {
		INT_STATUS = iNT_STATUS;
	}
	
	// 必須重新定義equals()與hashCode()
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
 
        if(!(obj instanceof PetRelationBean)) {
            return false;
        }
 
        PetRelationBean bean = (PetRelationBean) obj;
        return new EqualsBuilder()
                    .append(this.INT_MENID_MYSELF, bean.getINT_MENID_MYSELF())
                    .append(this.INT_MENID_LIKE, bean.getINT_MENID_LIKE())
                    .isEquals();
    }
 
    public int hashCode() {
        return new HashCodeBuilder()
                    .append(this.INT_MENID_MYSELF)
                    .append(this.INT_MENID_LIKE)
                    .toHashCode();
    }
}
