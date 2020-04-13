package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

public class PostTest {

    @Test
    public void toStringTest() {
        Post post = new Post("header", "author", "text", "img");
        Assert.assertEquals(post.toString(),"text");
    }

    @Test
    public void idTest(){
        Post post = new Post("header", "author", "text", "img");
        post.setId(23L);

        Long expected = post.getId();
        Long actual = 23L;

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void headerTest(){
        Post post = new Post("header", "author", "text", "img");
        post.setHeader("new header");

        String expected = post.getHeader();
        String actual = "new header";

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void authorTest(){
        Post post = new Post("header", "author", "text", "img");
        post.setAuthor("new author");

        String expected = post.getAuthor();
        String actual = "new author";

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void textTest(){
        Post post = new Post("header", "author", "text", "img");
        post.setText("new text");

        String expected = post.getText();
        String actual = "new text";

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void imgTest(){
        Post post = new Post("header", "author", "text", "img");
        post.setImageUrl("new img");

        String expected = post.getImageUrl();
        String actual = "new img";

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void tagsTest() {
        Post post = new Post("header", "author", "text", "img");

        Tag tag1 = new Tag("test1");
        Tag tag2 = new Tag("test2");
        Tag tag3 = new Tag("test3");

        Set<Tag> tags = new HashSet<>();
        post.setTags(tags);

        post.addTag(tag1);
        post.addTag(tag2);
        post.addTag(tag3);

        Integer expected = 3;
        Integer actual = post.getTags().size();

        Assert.assertEquals(expected, actual);

    }
}
