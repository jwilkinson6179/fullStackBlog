package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Comment;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.User;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void getterSetterTest(){
        User user = new User();
        user.setId(1L);
        user.setUserName("user name");
        user.setPassword("password");
        user.setDisplayName("display name");

        Long idE = user.getId();
        Long idA = 1L;

        String userE = user.getUserName();
        String userA = "user name";

        String passwordE = user.getPassword();
        String passwordA = "password";

        String displayE = user.getDisplayName();
        String displayA = "display name";

        Assert.assertEquals(idE,idA);
        Assert.assertEquals(userE,userA);
        Assert.assertEquals(passwordE,passwordA);
        Assert.assertEquals(displayE,displayA);
    }

    @Test
    public void commentListTest(){
        User user = new User();
        List<Comment> commentsUpvoted = new ArrayList<>();
        List<Comment> commentsDownvoted = new ArrayList<>();

        Comment c1 =new Comment();
        Comment c2 =new Comment();

        commentsUpvoted.add(c1);
        commentsDownvoted.add(c2);

        user.setCommentsUpvoted(commentsUpvoted);
        user.setCommentsDownvoted(commentsDownvoted);

        Integer expectedCU = user.getCommentsUpvoted().size();
        Integer expectedDU = user.getCommentsDownvoted().size();
        Integer actualCU = 1;
        Integer actualDU = 1;

        Assert.assertEquals(expectedCU,actualCU);
        Assert.assertEquals(expectedDU,actualDU);
    }
    @Test
    public void postListTest() {
        User user = new User();
        List<Post> posts = new ArrayList<>();

        Post post = new Post();
        posts.add(post);

        user.setPosts(posts);
        Integer expected = user.getPosts().size();
        Integer actual = 1;

        Assert.assertEquals(expected,actual);

    }

}
