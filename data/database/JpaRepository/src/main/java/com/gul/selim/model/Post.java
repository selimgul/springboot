package com.gul.selim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  title;

    // 1. yöntem - UniDirectional
    //@OneToMany(cascade= CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "post_id")
    //private List<PostComment> comments;

    //2. yöntem - BiDirectional
    @OneToMany(mappedBy = "post")
    private List<PostComment> comments;
}
