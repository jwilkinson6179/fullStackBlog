package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Comment;
import org.junit.Assert;
import org.junit.Test;

import java.security.Timestamp;
import java.time.LocalDateTime;

public class CommentTest {

    @Test
    public void GetterSetterTest(){
        Comment comment = new Comment();
        comment.setId(23L);
        comment.setAuthor("author");
        comment.setText("text");

        String AExpected = comment.getAuthor();
        String AActual = "author";

        String TExpected = comment.getText();
        String TActual = "text";

        Long idExpected = comment.getId();
        Long idActual = 23L;

        Assert.assertEquals(TExpected,TActual);
        Assert.assertEquals(AExpected, AActual);
        Assert.assertEquals(idExpected, idActual);
    }

    @Test
    public void timeTest(){
        Comment comment = new Comment();
        comment.setCreateTimestamp(LocalDateTime.now());

        comment.setUpdateTimestamp(LocalDateTime.now());

        Assert.assertNotNull(comment.getCreateTimestamp());
        Assert.assertNotNull(comment.getUpdateTimestamp());
    }
}
