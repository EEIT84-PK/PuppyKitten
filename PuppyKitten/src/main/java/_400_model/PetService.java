package _400_model;

import java.util.List;

import _500_model.MemberBean;

public class PetService {
	PetDAO_interface petDAO;

	public PetService() {
		petDAO = new PetDAO();
	}
	
	public PetBean selectId(Integer PET_ID) {		
		return petDAO.selectId(PET_ID);
	}	
	public PetImgBean selectId2(Integer PET_ID) {		
		return petDAO.selectId2(PET_ID);
	}
	public List<PetBean> selecPettId(Integer PET_OWN_ID) {		
		return petDAO.selectPetId(PET_OWN_ID);
	}	

	public List<PetBean> selectAll(){
		return petDAO.selectAll();
	}
	
	public List<PetRelationBean>selectRelationAll(){
		return petDAO.selectRelationAll();
	}
	
	public PetSortCatBean selectSortCat(String PET_SORT_ID){
		return petDAO.selectSortCat(PET_SORT_ID);
	}
	
	public PetSortDogBean selectSortDog(String PET_SORT_ID){
		return petDAO.selectSortDog(PET_SORT_ID);
	}
	
	public PetBean insert(PetBean bean) {
		petDAO.insert(bean);
		return bean;
	}
	public PetImgBean insert(PetImgBean bean) {
		petDAO.insert(bean);
		return bean;
	}
	
	public PetRelationBean insert(PetRelationBean bean){
		petDAO.insertRelation(bean);
		return bean;
	}
	

	public int delete(int PET_ID) {
		petDAO.delete(PET_ID);
		return PET_ID;
	}

	public PetBean update(PetBean bean) {
		petDAO.update(bean);
		return bean;
	}
}
