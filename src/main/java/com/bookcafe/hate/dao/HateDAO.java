package com.bookcafe.hate.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HateDAO {
	
	//유저 신고 확인
	public int selectHateList(
			@Param("userId") int userId, 
			@Param("subjectId") int subjectId);
	
	//유저별 누적신고수
	public int selectHateBySubjectId(@Param("subjectId") int subjectId);
	
	//신고 등록
	public int insertHate(
			@Param("userId") int userId,
			@Param("subjectId") int subjectId);

}
