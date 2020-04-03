package com.zipcode.fullstackblog.ModelTests;

import com.zipcode.fullstackblog.models.Tag;
import org.junit.Assert;
import org.junit.Test;

public class TagTests {

    @Test
    public void toStringTest(){
        Tag tag = new Tag();
        tag.setName("This is a test");
        Assert.assertEquals(tag.toString(),"This is a test");
    }


}
