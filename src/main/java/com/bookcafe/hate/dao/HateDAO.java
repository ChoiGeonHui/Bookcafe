package com.bookcafe.hate.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HateDAO {
	
	//���� �Ű� Ȯ��
	public int selectHateList(
			@Param("userId") int userId, 
			@Param("subjectId") int subjectId);
	
	//������ �����Ű��
	public int selectHateBySubjectId(@Param("subjectId") int subjectId);
	
	//�Ű� ���
	public int insertHate(
			@Param("userId") int userId,
			@Param("subjectId") int subjectId);

}
