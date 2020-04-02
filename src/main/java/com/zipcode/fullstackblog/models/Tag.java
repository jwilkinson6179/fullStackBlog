package com.zipcode.fullstackblog.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnoreProperties("tags")
    @MapsId("tag_id")
    private Set<Post> posts;

    private String name;

    public Tag() {}

    public Tag(String name) {
        this.name = name;
        this.posts = new HashSet<>();

    }

    public Tag(Long id, String name) {
        this.name = name;
        this.id = id;
        this.posts = new HashSet<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long tagID) {
        this.id = tagID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPost(Set<Post> post) {
        this.posts = post;
    }

    public void addPost(Post post)
    {
        posts.add(post);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(getId(), tag.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
