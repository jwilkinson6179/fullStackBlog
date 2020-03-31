package com.zipcode.fullstackblog;

import com.zipcode.fullstackblog.controllers.*;
import com.zipcode.fullstackblog.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class Application
{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Board board = new Board("Test Board");
		Post postOne = new Post("My Test Posting", "Adam", "Adam is writing a post to the test board to see what the results of that might look like. Check me out!", "none");
		Tag tagA = new Tag("Adam");
		Tag tagB = new Tag("Cool post");
		Tag tagC = new Tag("Cool guy");
		postOne.addTag(tagA);
		postOne.addTag(tagB);
		postOne.addTag(tagC);
		board.addPost(postOne);

		BoardController.save(board);
		Integer boardDBSize = BoardController.count();
//		Page<Post> postPages = PostController.getAllPosts();
		System.out.println(boardDBSize);
//		System.out.println(postDBSize);
	}
}