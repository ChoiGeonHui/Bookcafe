package com.bookcafe.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeDAO {
	
	//게시물 추천수
	public int selectlikeByPostId(int postId);
	
	//게시물에 특정유저 추천 여부
	public int selectlikeByPostIdboolean(
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	//추천 등록
	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	//추천취소
	public void deleteLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	//삭제된 게시물 추천 지우기
	public void deleteLikeByPostId(
			@Param("postId") int postId);
}
