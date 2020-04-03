package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Post;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PostTest {

    @Test
    public void toStringTest() {
        Post post = new Post("header", "author", "text", "img");
        Assert.assertEquals(post.toString(),"text");
    }
}
