package com.bookcafe.post.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookcafe.common.FileManagerSurvice;
import com.bookcafe.post.dao.PostDAO;
import com.bookcafe.post.model.Post;

@Service
public class PostBO {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	FileManagerSurvice fileManagerSurvice;
	
	public int createPost(int userId, String userName, String tag, String title, String content,
			MultipartFile file,Integer price) {
		
		String imagePath = null;	
		if (file != null) {
			try {
				imagePath = fileManagerSurvice.saveFile(userName, file);
			} catch (Exception e) {
				log.error("파일 에러 :"+e.getMessage());
			}
		}	
		return postDAO.createPost(userId, tag, title, content, imagePath, price);
	}
	
	
	
	public int updatePost(int userId, String userName,int postId, String tag, String title, String content,
			MultipartFile file,Integer price) {
		
		String imagePath = null;	
		if (file != null) {
			try {
				
				Post post = postDAO.selectPostById(postId);
				
				imagePath = fileManagerSurvice.saveFile(userName, file);
				
				String oldImagePath = post.getImagePath();
				
				if(oldImagePath !=null && imagePath!=null) {
					fileManagerSurvice.deleteFile(oldImagePath);			
				}		
				
			} catch (Exception e) {
				log.error("파일 에러 :"+e.getMessage());
			}
		}
		
		
		return postDAO.updatePost(userId, postId, tag, title, content, imagePath, price);
	}
	
	public int deletePostById(int userId, int postId) {
		return postDAO.deletePost(userId, postId);
	}
	
	
	public Post selectPostById(int postId){
		return postDAO.selectPostById(postId);
	}
	
	
	public List<Post> selectList(String tag, String search){
		return postDAO.selectPostList(tag,search);
	}
	

}
