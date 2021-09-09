package com.bookcafe.post.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookcafe.common.FileManagerSurvice;
import com.bookcafe.post.dao.PostDAO;

@Service
public class PostBO {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	FileManagerSurvice fileManagerSurvice;
	
	public int createPost(int userId, String userName, String tag, String title, String content,
			MultipartFile file,int price) {
		
		String imagePath = "";	
		if (file != null) {
			try {
				imagePath = fileManagerSurvice.saveFile(userName, file);
			} catch (Exception e) {
				log.error("파일 업로드 :"+e.getMessage());
			}
		}
		
		
		return postDAO.createPost(userId, tag, title, content, imagePath, price);
	}

}
