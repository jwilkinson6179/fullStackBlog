package com.zipcode.fullstackblog.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TagTest
{
    Tag testTagA;
    Tag testTagB;

    @Before
    public void setup()
    {
        testTagA = new Tag(1L, "testing");
        testTagB = new Tag(2L, "testing");
    }

    @Test
    public void testForEquality()
    {
        assertEquals(testTagA, testTagB);
    }

    @Test
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