package _400_model;



public interface PetDAO_interface {
	public PetBean selectId(int PET_ID);
	public PetImgBean selectId2(int PET_ID);
	public PetSortCatBean selectSortCat(String PET_SORT_ID);
	public PetSortDogBean selectSortDog(String PET_SORT_ID);
	public void insert(PetBean bean);
	public void delete(int PET_ID);
	public void update(PetBean bean);
	public void insert(PetImgBean bean);
}
