package kr.ac.hojun.cse.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hojun.cse.model.Post;

@Repository
public class PostDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Post> getPosts() {
		//System.out.println("list print");
		String sqlStatement = "select * from post";  //record -> object
		
		////rowmapper -> record로 넘어온 db데이터를 객체로 mapping
		return jdbcTemplate.query(sqlStatement, new RowMapper<Post>(){

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setPriority(rs.getString("priority"));
				post.setDeadline(rs.getDate("deadline"));
				post.setState(rs.getString("state"));
				post.setDescription(rs.getString("description"));
			
				return post;
			}
		});
	}

	//입력 받은 post db에 저장
	
	public boolean addPost(Post post) {
		
		String title = post.getTitle();
		String priority = post.getPriority(); 
		Date deadline = post.getDeadline();
		String state = post.getState();
		String description = post.getDescription();
		
		String sqlStatement = "insert into post (title, priority, deadline, state, description) values(?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, 
				new Object[] {title, priority, deadline, state, description}) == 1);
	}

	public boolean deletePost(int id) {
		
		String sqlStatement = "delete from post where id = ?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}

	public Post getPostById(int id) {

		String sqlStatement = "select * from post where id = ?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {id}, new RowMapper<Post>() {
			
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setPriority(rs.getString("priority"));
				post.setDeadline(rs.getDate("deadline"));
				post.setState(rs.getString("state"));
				post.setDescription(rs.getString("description"));

				return post;
			}
		});
	}

	public boolean updatePost(Post post) {
		
		int id = post.getId();
		String title = post.getTitle();
		String priority = post.getPriority(); 
		Date deadline = post.getDeadline();
		String state = post.getState();
		String description = post.getDescription();
		
		String sqlStatement = "update post set title=?, priority=?, deadline=?, state=?, description=? "
							+ "where id=?";
		
		return (jdbcTemplate.update(sqlStatement, 
				new Object[] {title, priority, deadline, state, description, id}) == 1);
		
	}
}
