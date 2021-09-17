package com.bookcafe.timeline.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.buy.bo.BuyBO;
import com.bookcafe.comment.bo.CommentBO;
import com.bookcafe.comment.model.Comment;
import com.bookcafe.common.FileManagerSurvice;
import com.bookcafe.like.bo.LikeBO;
import com.bookcafe.post.bo.PostBO;
import com.bookcafe.post.model.Post;
import com.bookcafe.timeline.domain.Content;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@Service
public class ContentBO {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private BuyBO buyBO;
	
	@Autowired
	FileManagerSurvice fileManagerSurvice;
	
	//게시글 리스트
	public List<Content> contentList(int userId,String pagetag){
		List<Content> contentlist = new ArrayList<>();
		
		List<Post> postlist = postBO.selectList(pagetag);
		
		for (Post post : postlist) {
			Content content = new Content();
			
			content.setPost(post);
			
			User user = userBO.selectUser(post.getUserId());
			content.setUser(user);
			
			List<Comment> commentList = commentBO.selectComment(post.getId());
			content.setCommentList(commentList);
			
			int countlike = likeBO.likeConuntByPost(post.getId());
			content.setLikeCount(countlike);
			
			
			if(pagetag!=null&&pagetag.equals("추천글")&&countlike<5) {
				continue;
			}	
			
			boolean likeUser = likeBO.likebooleanByPostUserId(post.getId(), userId);
			content.setLikefile(likeUser);
			
			boolean buyedPost = true;
			if(post.getPrice()!=null) {
				buyedPost = buyBO.checkBuyed(userId, post.getId());
			}
			
			content.setBuyfile(buyedPost);
			
			contentlist.add(content);
					
		}
		
		
		return contentlist;
	}
	
	//단일 게시물
	public Content selectContent(int userId,int postId) {
		
		Content content = new Content();
		content.setPost(postBO.selectPostById(postId));
		content.setUser(userBO.selectUser(content.getPost().getUserId()));
		content.setCommentList(commentBO.selectComment(postId));
		content.setLikeCount(likeBO.likeConuntByPost(postId));
		content.setLikefile(likeBO.likebooleanByPostUserId(postId, userId));
		
		boolean buyedPost = true;
		if(content.getPost().getPrice()!=null) {
			buyedPost = buyBO.checkBuyed(userId, postId);
		}	
		content.setBuyfile(buyedPost);
		
		
		
		return content;
	}
	
	//해당게시물,추천,댓글,buy 삭제
	public String deleteContent(int userId, int postId) {
		
		Post post = postBO.selectPostById(postId);
		
		try {
			fileManagerSurvice.deleteFile(post.getImagePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		likeBO.deleteLikeByPostId(postId);
		commentBO.deleteCommetByPostId(postId);
		buyBO.deleteBuyByPostId(postId);
		int row = postBO.deletePostById(userId, postId);
		
		if(row>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	

}
