package com.zipcode.fullstackblog.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "board", targetEntity = Post.class)
    List<Post> posts;

    String title;

    public Board() {}

    public Board(String title) {
        this.title = title;
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public Boolean contains(Post post) {
        return this.posts.contains(post);
    }

    public Post getPost(int index) {
        return this.posts.get(index);
    }

    public Integer size() {
        return this.posts.size();
    }

    public ArrayList<Post> getAllPosts() {
        return posts;
    }

    public ArrayList<Post> getPosts(Tag tag) {
        ArrayList<Post> output = new ArrayList<>();
        for (Post post : posts) {
            for (Tag t : post.getTags()) {
                if (t.equals(tag)) {
                    output.add(post);
                }
            }
        }
        return output;
    }

    public ArrayList<Post> getPostsByName(String match) {
        ArrayList<Post> output = new ArrayList<>();
        for (Post post : posts) {
            if (post.getTitle().equals(match)) {
                output.add(post);
            }
        }
        return output;
    }

    public ArrayList<Post> getPostsByText(String match) {
        ArrayList<Post> output = new ArrayList<>();
        for (Post post : posts) {
            if (post.getText().contains(match)) {
                output.add(post);
            }
        }
        return output;
    }

    public void delete(Post post) {
        this.posts.remove(post);
    }

    public Boolean editPost(Post postToEdit, Post updatedPost) {
        for (Post post : posts) {
            if (post.equals(postToEdit)) {
                post = updatedPost;
                // actually update post
                return true;
            }
        }
        return false;
    }

    public Boolean editPost(Long postToEdit, Post updatedPost) {
        for (Post post : posts) {
            if (post.getId().equals(postToEdit)) {
                post = updatedPost;
                // actually update post
                return true;
            }
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


