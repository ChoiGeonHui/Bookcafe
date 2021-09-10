package com.bookcafe.timeline.domain;

import java.util.List;

import com.bookcafe.comment.model.Comment;
import com.bookcafe.post.model.Post;
import com.bookcafe.user.model.User;

public class Content {

	private Post post;
	
	private User user;
	
	private List<Comment> commentList;
	
	private int likeCount;
	
	private boolean likefile;
	
	private boolean buyfile;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public boolean isLikefile() {
		return likefile;
	}

	public void setLikefile(boolean likefile) {
		this.likefile = likefile;
	}

	public boolean isBuyfile() {
		return buyfile;
	}

	public void setBuyfile(boolean buyfile) {
		this.buyfile = buyfile;
	}
	
	

}
