package com.epam.lab.socialmediaaitask.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Post {


    private Long id;


    private String title;


    private String body;

    private Set<Like> likes;

    private User author;


}
