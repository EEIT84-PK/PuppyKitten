package _400_model;

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
	public PetBean insert(PetBean bean) {
		petDAO.insert(bean);
		return bean;
	}
	public PetImgBean insert(PetImgBean bean) {
		petDAO.insert(bean);
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
