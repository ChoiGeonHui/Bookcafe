package com.bookcafe.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.like.dao.LikeDAO;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	public int likeConuntByPost(int postId) {
		return likeDAO.selectlikeByPostId(postId);
	}
	
	public boolean likebooleanByPostUserId(int postId,int userId) {
		int row= likeDAO.selectlikeByPostIdboolean(postId,userId);
		return row>0? true:false;
	}
	
	
	public String OnOffLikeById(int postId, int userId) {
		
		Boolean likeLog = likebooleanByPostUserId(postId, userId);
			
		//이미 추전을 누른 여부에 따라 달라짐
		if(likeLog) {
			likeDAO.deleteLike(postId, userId);
			return "delete";
		}else {		
			likeDAO.insertLike(postId, userId);
			return "insert";
		}

		
	}
	
	public void deleteLikeByPostId(int postId) {
		likeDAO.deleteLikeByPostId(postId);
	}

}
