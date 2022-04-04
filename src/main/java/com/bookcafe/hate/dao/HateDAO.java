package com.bookcafe.hate.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HateDAO {
	
	//신고 확인 여부(중복 신고 방지)
	public int selectHateList(
			@Param("userId") int userId, 
			@Param("subjectId") int subjectId);
	
	//누적 피신고 횟수
	public int selectHateBySubjectId(@Param("subjectId") int subjectId);
	
	//신고 등록
	public int insertHate(
			@Param("userId") int userId,
			@Param("subjectId") int subjectId);

}
