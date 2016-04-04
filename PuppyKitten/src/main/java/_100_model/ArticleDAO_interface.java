package _100_model;

import java.util.List;

public interface ArticleDAO_interface {

	List<ArticleBean> selectAll();
	List<ArticleBean> selectPost();
	List<ArticleBean> selectActivity();
	List<ArticleBean> selectReviews();
	List<ArticleBean> selectQuestion();
	List<ArticleBean> selectByTitle(String title);

}