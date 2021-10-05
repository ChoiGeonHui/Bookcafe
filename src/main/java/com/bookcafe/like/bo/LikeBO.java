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
		//해당 게시글 좋아요 여부
		Boolean likeLog = likebooleanByPostUserId(postId, userId);
			
		//좋아요 등록, 취소하기
		if(likeLog) {
			likeDAO.deleteLike(postId, userId);
			return "delete";
		}else {		
			likeDAO.insertLike(postId, userId);
			return "insert";
		}
	}
	
	//삭제된 게시물 추천 지우기
	public void deleteLikeByPostId(int postId) {
		likeDAO.deleteLikeByPostId(postId);
	}

}
