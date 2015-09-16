package com.sven.dream.blog.vo;
 
import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.user.UserDo;

public class BlogVo {
	private long id;
	  
    private String title;
 
    private String content;
 
    private String publishTime;
 
    private UserDo user;
    
    private FileDo userFilePic;
    
    private FileDo blogBgPic;
    
    private boolean hasBlogBgPic = false;
    
    private int totoalComments;
 
    private Long categoryId;
 
    private String keyword;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isHasBlogBgPic() {
		return hasBlogBgPic;
	}

	public void setHasBlogBgPic(boolean hasBlogBgPic) {
		this.hasBlogBgPic = hasBlogBgPic;
	}

	public FileDo getBlogBgPic() {
		return blogBgPic;
	}

	public void setBlogBgPic(FileDo blogBgPic) {
		this.blogBgPic = blogBgPic;
	}

	public int getTotoalComments() {
		return totoalComments;
	}

	public void setTotoalComments(int totoalComments) {
		this.totoalComments = totoalComments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
 
	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public UserDo getUser() {
		return user;
	}

	public void setUser(UserDo user) {
		this.user = user;
	}

	public FileDo getUserFilePic() {
		return userFilePic;
	}

	public void setUserFilePic(FileDo userFilePic) {
		this.userFilePic = userFilePic;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	} 
}
