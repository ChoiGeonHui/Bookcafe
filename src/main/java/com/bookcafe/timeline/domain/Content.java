package com.bookcafe.timeline.domain;

import java.util.List;

import com.bookcafe.comment.model.Comment;
import com.bookcafe.post.model.Post;
import com.bookcafe.user.model.User;


//게시물에 들어가는 항목들
public class Content {
	
	private Post post; //게시물
	
	private User user; //게시물 작성자
	
	private List<Comment> commentList;  
	//게시물 댓글 리스트
	
	private int likeCount;
	//게시물 추천수 
	
	private boolean likefile;
	//내가 이 게시물 추천 여부
	
	private boolean buyfile;
	//내가 이 게시물 구매 여부

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
