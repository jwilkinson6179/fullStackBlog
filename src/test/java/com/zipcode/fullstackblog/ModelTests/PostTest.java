package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Comment;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

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

    public static class TagTest
    {
        Tag testTagA;
        Tag testTagB;

        @Before
        public void setup()
        {
            testTagA = new Tag(1L, "testing");
            testTagB = new Tag(2L, "testing");
        }

        @org.junit.Test
        public void testForEquality()
        {
            assertEquals(testTagA, testTagB);
        }

        @org.junit.Test
        public void testSetCorrectness()
        {
            Integer expected = 1;
            Set<Tag> testSet = new HashSet<>();
            Tag testTagC = new Tag(15L, "testing");
            testSet.add(testTagA);
            testSet.add(testTagB);
            Integer actual = testSet.size();
            System.out.println(actual);
            assertEquals(expected, actual);
        }
    }
    @Test
    public void commentsTest() {
        Post post = new Post();

        Comment c1 = new Comment();
        Comment c2 = new Comment();
        Comment c3 = new Comment();

        List<Comment> comments = new ArrayList<>();
        post.setComments(comments);

        comments.add(c1);
        comments.add(c2);
        comments.add(c3);

        Integer expected = 3;
        Integer actual = post.getComments().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void timeTest(){
        Post post = new Post();
        post.setCreateTimestamp(LocalDateTime.now());

        post.setUpdateTimestamp(LocalDateTime.now());

        Assert.assertNotNull(post.getCreateTimestamp());
        Assert.assertNotNull(post.getUpdateTimestamp());
    }

}
