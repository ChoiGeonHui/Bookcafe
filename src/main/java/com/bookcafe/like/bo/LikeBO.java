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

}
