package com.zipcode.fullstackblog.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String displayName;

    @Transient
    private List<Post> posts;

    @Transient
    private List<Comment> commentsUpvoted;

    @Transient
    private List<Comment> commentsDownvoted;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getCommentsUpvoted() {
        return commentsUpvoted;
    }

    public void setCommentsUpvoted(List<Comment> commentsUpvoted) {
        this.commentsUpvoted = commentsUpvoted;
    }

    public List<Comment> getCommentsDownvoted() {
        return commentsDownvoted;
    }

    public void setCommentsDownvoted(List<Comment> commentsDownvoted) {
        this.commentsDownvoted = commentsDownvoted;
    }
}
