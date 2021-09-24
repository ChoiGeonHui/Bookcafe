package com.bookcafe.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.user.model.User;

@Repository
public interface UserDAO {
	
	public User selectTest();
	
	
	
	public User selectUser(int userId);
	
	public List<User> selectUserList();
	
	
	//���̵� �ߺ�Ȯ��
	public int selectUserByloginIdCheck(
			@Param("loginId") String loginId);
	
	//�α���
	public User selectUserLogin(
			@Param("loginId") String loginId,
			@Param("password") String password);
	
	
	
	//ȸ������
	public int insertUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email);
	
	
	//���������Ʈ ����
	public int updatePlusPointByUserId(
			@Param("userId") int userId,
			@Param("point") int point);
	
	//����Ʈ ����
	public int updateMinusPointByUserId(
			@Param("userId") int userId,
			@Param("point") int point);
	
	
	//ȸ�� ���� ����
	public int updateUserByColumns(
			@Param("userId") int userId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email
			);
	
	//���� ����
	public Integer findUserByLoginIdAndNameAndEmail(
			@Param("loginId") String loginId,
			@Param("name") String name,
			@Param("email") String email
			);
	
	//��й�ȣ ����
	public int updateUserByIdSetPassword(
			@Param("id") int id,
			@Param("password") String password
			);
	
	//���� Ż��
	public int updateUserExceptById(@Param("id") int id);
	
	public int updateUserClass(
			@Param("id") int id,
			@Param("userClass") String userClass
			);
}
