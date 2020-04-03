package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Board;
import com.zipcode.fullstackblog.models.Post;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BoardTests {

    @Test
    public void addPostTest(){
        Board board = new Board("Test");
        Post post = new Post();
        board.addPost(post);

        Assert.assertTrue(board.contains(post));
    }

    @Test
    public void getPostByNameTest(){
        Board board = new Board("Hello");

        Post post1 = new Post("header","author","text","img");
        Post post2 = new Post("header","author","text","img");
        Post post3 = new Post("header","author","text","img");
        Post postTest = new Post("test","author","text","img");

        board.addPost(post1);
        board.addPost(post2);
        board.addPost(post3);
        board.addPost(postTest);
        ArrayList<Post> posts = board.getPostsByName("header");

        Assert.assertEquals(posts.size(),3);
    }
    @Test
    public void getPostByTextTest(){
        Board board = new Board("Hello");

        Post post1 = new Post("header","author","text","img");
        Post post2 = new Post("header","author","text","img");
        Post post3 = new Post("header","author","text","img");
        Post postTest = new Post("header","author","test","img");

        board.addPost(post1);
        board.addPost(post2);
        board.addPost(post3);
        board.addPost(postTest);
        ArrayList<Post> posts = board.getPostsByText("text");

        Assert.assertEquals(posts.size(),3);
    }
    @Test
    public void deleteTest(){
        Board board = new Board("Hello");

        Post post1 = new Post("header","author","text","img");
        Post post2 = new Post("header","author","text","img");
        Post post3 = new Post("header","author","text","img");
        Post postTest = new Post("header","author","test","img");

        board.addPost(post1);
        board.addPost(post2);
        board.addPost(post3);
        board.addPost(postTest);
        ArrayList<Post> posts = (ArrayList<Post>) board.getPosts();
        board.delete(postTest);

        Assert.assertEquals(board.size(),(Integer) 3);
    }
    @Test
    public void editPostTrue() {
        Board board = new Board("Hello");

        Post post1 = new Post("header", "author", "text", "img");
        Post post2 = new Post("header", "author", "text", "img");

        board.addPost(post1);

        Assert.assertTrue( board.editPost(post1,post2));

    }
    @Test
    public void editPostFalse() {
        Board board = new Board("Hello");

        Post post1 = new Post("header", "author", "text", "img");
        Post post2 = new Post("header", "author", "text", "img");
        post1.setId(1L);

        Assert.assertFalse( board.editPost(1L,post2));

    }

}
