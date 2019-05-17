package kr.ac.hojun.cse.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {
	private int id;
	private String title;
	private String priority;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	
	private String state;
	private String description;
	/* ..?
	public void setDeadline(java.util.Date parse) {
		// TODO Auto-generated method stub
		
	}*/
	
}
