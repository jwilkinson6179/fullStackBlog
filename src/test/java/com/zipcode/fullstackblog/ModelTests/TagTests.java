package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TagTests {

    @Test
    public void toStringTest(){
        Tag tag = new Tag();
        tag.setName("This is a test");
        Assert.assertEquals(tag.toString(),"This is a test");
    }

    @Test
    public void nameTest(){
        Tag tag = new Tag();
        tag.setName("name");
        String expected = tag.getName();

        Assert.assertEquals(expected,"name");
    }
    @Test
    public void idTest(){
        Tag tag = new Tag();
        tag.setId(23L);

        Long expected = tag.getId();
        Long actual = 23L;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void postTest(){
        Tag tag = new Tag("test");

        Post post1 = new Post("header","author","text","img");
        Post post2 = new Post("header","author","text","img");
        Post post3 = new Post("header","author","text","img");
        post1.setId(1L);
        post2.setId(2L);
        post3.setId(3L);

        Set<Post> posts = new HashSet<>();
        tag.setPost(posts);

        tag.addPost(post1);
        tag.addPost(post2);
        tag.addPost(post3);

        Integer expected = tag.getPosts().size();
        Integer actual = 3;

        Assert.assertEquals(expected, actual);
    }


}
