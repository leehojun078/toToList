package kr.ac.hojun.cse.controller;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hojun.cse.model.Post;
import kr.ac.hojun.cse.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/postInventory")
	public String getPosts(Model model) { //db 조회 후 데이터를 model에 맵핑 -> view
		
		List<Post> posts = postService.getPosts();
		model.addAttribute("posts",posts);
		
		return "postInventory";
	}
				
	//Get method
	@RequestMapping(value="/postInventory/addPost", method=RequestMethod.GET)
	public String addPost(Model model) throws ParseException {
		Post post = new Post();
		
		//초기화
		/* date converting */
		String date = "2099-12-31";
        
        // Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // 현재 yyyy-mm-dd로된 날짜 형식으로 java.util.Date객체를 만든다.
            tempDate = afterFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
        String transDate = afterFormat.format(tempDate);
        // 반환된 String 값을 Date로 변경한다.
        Date d = Date.valueOf(transDate);
        post.setDeadline(d);
        
		//post.setDeadline(new SimpleDateFormat("yyyy-MM-dd").parse("2099-12-31"));
		post.setPriority("상");
		post.setState("미완료");
		//post.setTitle("계획");
		//post.setDescription("내일까지");
		model.addAttribute("post", post);
		
		return "addPost";
	}
	
	//Post method
	@RequestMapping(value="/postInventory/addPost", method=RequestMethod.POST)
	public String addPostPost(Post post) {
		
		//service layer를 통해 db에 저장하도록
		if(!postService.addPost(post)) { 
			System.out.println("Adding post cannot be done");
		}
		
		return "redirect:/admin/postInventory"; //redirect로 29번쨰 줄로 가서 update후 재출력
	}
	
	//delete
	@RequestMapping(value="/postInventory/deletePost/{id}", method=RequestMethod.GET)
	public String deletePost(@PathVariable int id) throws ParseException {
		
		if(!postService.deletePost(id)) {
			System.out.println("Deleting post cannot be dones");
		}
		
		return "redirect:/admin/postInventory"; 
	}
	
	//update
	@RequestMapping(value="/postInventory/updatePost/{id}", method=RequestMethod.GET)
	public String updatePost(@PathVariable int id, Model model) throws ParseException {
		
		Post post = postService.getPostById(id);
		model.addAttribute("post", post);
		
		return "updatePost";
	}
	
	@RequestMapping(value="/postInventory/updatePost", method=RequestMethod.POST)
	public String updatePostPost(Post post) {
		
		//data binding으로 들어오는 post를 출력
		//System.out.println(post);
		
		//service layer를 통해 db에 저장하도록
		if(!postService.updatePost(post)) { 
			System.out.println("Updating post cannot be done");
		}
		return "redirect:/admin/postInventory"; 
	}
	
	
	
	
}