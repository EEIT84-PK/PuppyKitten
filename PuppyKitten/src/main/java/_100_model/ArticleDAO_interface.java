package _100_model;

import java.util.List;

public interface ArticleDAO_interface {

	public List<ArticleBean> selectAll();
	public List<ArticleBean> selectPost();
	public List<ArticleBean> selectActivity();
	public List<ArticleBean> selectReviews();
	public List<ArticleBean> selectQuestion();
	public List<ArticleBean> selectByTitle(String title);
	public void insert(ArticleBean bean);
	public void update(ArticleBean bean);
	public void delete(int ART_ID);
	public List<ArticleBean> selectSort();

}