package com.epam.lab.socialmediaaitask.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class User {

    private Long id;

    private String username;

    private List<Post> posts;

    private Set<Like> likes;

    private Set<User> followers;


}