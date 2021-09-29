package com.bookcafe.buy.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyDAO {
	
	//���� Ȯ��
	public int selectByUserIdPostId(
			@Param("userId") int userId,
			@Param("postId") int postId
			);
	
	//�����ϱ�
	public int insertBuylist(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("price") int price
			);
	
	//����
	public void deleteBuyByPostId(int postId);
}
