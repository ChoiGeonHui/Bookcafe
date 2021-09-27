package com.bookcafe.hate.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HateDAO {
	
	public int selectHateList(
			@Param("userId") int userId, 
			@Param("subjectId") int subjectId);
	
	public int selectHateBySubjectId(@Param("subjectId") int subjectId);
	
	public int insertHate(
			@Param("userId") int userId,
			@Param("subjectId") int subjectId);

}
