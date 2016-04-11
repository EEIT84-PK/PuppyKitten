package _400_model;

import java.util.List;

import _500_model.MemberBean;

public interface PetDAO_interface {
	public PetBean selectId(int PET_ID);
	public List<PetBean> selectPetId(int PET_OWN_ID);
	public PetImgBean selectId2(int PET_ID);
	public PetSortCatBean selectSortCat(String PET_SORT_ID);
	public PetSortDogBean selectSortDog(String PET_SORT_ID);
	public void insert(PetBean bean);
	public void delete(int PET_ID);
	public void update(PetBean bean);
	public void insert(PetImgBean bean);
	public void insertRelation(PetRelationBean bean);
	public List<PetBean> selectAll();
	public List<PetRelationBean> selectRelationAll();	


}
