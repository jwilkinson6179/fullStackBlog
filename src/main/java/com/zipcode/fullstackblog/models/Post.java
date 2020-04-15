package com.zipcode.fullstackblog.models;

import com.fasterxml.jackson.annotation.*;
import com.zipcode.fullstackblog.controllers.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;@ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"allPosts", "posts"})
    private Board board;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "post", targetEntity = Comment.class)
    @JsonIgnoreProperties("post")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Comment> comments;

    private String header;
    private String author;
    private String text;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime createTimestamp;
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tagged_posts",
            joinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")})
    @JsonIgnoreProperties("posts")
    private Set<Tag> tags;

    public Post() {}

    public Post(String header, String author, String text, String imageUrl)
    {
        this.header = header;
        this.author = author;
        this.text = text;
        this.imageUrl = imageUrl;
        this.createTimestamp = LocalDateTime.now();
        this.tags = new HashSet<>();
        this.board = new Board();
        this.comments = new ArrayList<>();
    }

    public Post(String header, String author, String text, String imageUrl, boolean timestamp)
    {
        this.header = header;
        this.author = author;
        this.text = text;
        this.imageUrl = imageUrl;
        if (timestamp) {
            this.createTimestamp = LocalDateTime.now();
        }
        this.tags = new HashSet<>();
        this.board = new Board();
        this.comments = new ArrayList<>();
    }

    public void editPost(Post newPost)
    {
        this.imageUrl = newPost.getImageUrl();
        this.author = newPost.getAuthor();
        this.text = newPost.getText();
        this.header = newPost.getHeader();
        this.tags = newPost.getTags();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(LocalDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        for (Comment cmt : comments) {
            for (Comment c : CommentController.getServ().findAll()) {
                if (c.equals(cmt)) {
                    cmt = c;
                }
            }
        }
        this.comments = comments;
    }

    public void setTags(Set<Tag> tags) {
        for (Tag tag : tags) {
            for (Tag t : TagController.getServ().findAll()) {
                if (t.getName().equals(tag.getName())) {
                    tag = t;
                }
            }
        }
        this.tags = tags;
    }

    public void setBoard(Board board) {
        boolean found = false;
        for (Board b : BoardController.getServ().findAll()) {
            if (b.getTitle().equals(board.getTitle())) {
                this.board = b;
                return;
            }
        }
        this.board = board;
    }

    public void addTag(Tag tag)
    {
        this.tags.add(tag);
    }

    @Override
    public String toString()
    {
        return this.text;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId());
    }


}
