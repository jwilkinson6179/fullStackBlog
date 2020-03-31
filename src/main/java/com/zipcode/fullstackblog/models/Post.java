package com.zipcode.fullstackblog.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    private String author;
    private String text;
    private String imageUrl;
    private LocalDate timestamp;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "post", targetEntity = Tag.class)
    private Set<Tag> tags;

    public Post() {}

    public Post(String header, String author, String text, String imageUrl) {
        this.header = header;
        this.author = author;
        this.text = text;
        this.imageUrl = imageUrl;
        this.timestamp = LocalDate.now();
        this.tags = new HashSet<>();
    }


    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public LocalDate getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp)
    {
        this.timestamp = timestamp;
    }

    public Set<Tag> getTags()
    {
        return tags;
    }

    public void setTags(Set<Tag> tags)
    {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}