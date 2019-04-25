package com.example.trippify.api.Trip.model;

import com.example.trippify.api.Post.model.Post;
import com.example.trippify.api.User.model.User;
import com.example.trippify.model.AuthProvider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;



    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date endDate;

    private long daysNumber;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    private String imageUrl;

    public long getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(long daysNumber) {
        this.daysNumber = daysNumber;
    }

    @ManyToOne
    private User traveller;


    public Integer getNbComments() {
        return nbComments;
    }

    public void setNbComments(Integer nbComments) {
        this.nbComments = nbComments;
    }

    public Integer getNbViews() {
        return nbViews;
    }

    public void setNbViews(Integer nbViews) {
        this.nbViews = nbViews;
    }

    public Integer getNbLikes() {
        return nbLikes;
    }

    public void setNbLikes(Integer nbLikes) {
        this.nbLikes = nbLikes;
    }

    private Integer nbComments;
    private Integer nbViews;
    private Integer nbLikes;

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Post> posts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getTraveller() {
        return traveller;
    }

    public void setTraveller(User traveller) {
        this.traveller = traveller;
    }
}

