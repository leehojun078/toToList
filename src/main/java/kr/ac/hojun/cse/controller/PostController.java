package kr.ac.hojun.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hojun.cse.model.Post;
import kr.ac.hojun.cse.service.PostService;

@Controller
public class PostController { // controller -> service -> dao
	
	@Autowired 
	private PostService postService;
	
	@RequestMapping("/posts") 
	public String getPosts(Model model) {
		
		List<Post> posts = postService.getPosts();
		model.addAttribute("posts", posts);
		
		return "posts";
	}
	
	
}
 