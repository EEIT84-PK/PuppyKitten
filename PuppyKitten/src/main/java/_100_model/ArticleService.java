package _100_model;

import java.util.List;

public class ArticleService {
	ArticleDAO_interface dao;
	
	public ArticleService(){
		dao = new ArticleDAO();
	}
	
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = dao.selectAll();
		return list;
	}
	public List<ArticleBean> selectAllTime() {
		List<ArticleBean> list = dao.selectAllTime();
		return list;
	}
	public List<ArticleBean> selectAllHot() {
		List<ArticleBean> list = dao.selectAllHot();
		return list;
	}
	public List<ArticleBean> selectAllKind() {
		List<ArticleBean> list = dao.selectAllKind();
		return list;
	}
	public List<ArticleBean> selectSort() {
		List<ArticleBean> list = dao.selectSort();
		return list;
	}
	public List<ArticleBean> selectPost() {
		List<ArticleBean> list = dao.selectPost();
		return list;
	}
	public List<ArticleBean> selectActivity() {
		List<ArticleBean> list = dao.selectActivity();
		return list;
	}
	public List<ArticleBean> selectReviews() {
		List<ArticleBean> list = dao.selectReviews();
		return list;
	}
	public List<ArticleBean> selectQuestion() {
		List<ArticleBean> list = dao.selectQuestion();
		return list;
	}
	public List<ArticleBean> selectByTitle(String title){
		List<ArticleBean> list = dao.selectByTitle(title);
		return list;
	}
	public ArticleBean insert(ArticleBean bean){
			dao.insert(bean);
		return bean;
	} 
	public ArticleBean update(ArticleBean bean){
		dao.update(bean);
	return bean;
} 
	public int delete(int id){
		dao.delete(id);
	return id;
} 
}
