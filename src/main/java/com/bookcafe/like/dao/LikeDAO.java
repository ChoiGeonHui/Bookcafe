package com.bookcafe.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeDAO {
	
	//�Խù� ��õ��
	public int selectlikeByPostId(int postId);
	
	//�Խù��� Ư������ ��õ ����
	public int selectlikeByPostIdboolean(
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	//��õ ���
	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	//��õ���
	public void deleteLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	//������ �Խù� ��õ �����
	public void deleteLikeByPostId(
			@Param("postId") int postId);
}
