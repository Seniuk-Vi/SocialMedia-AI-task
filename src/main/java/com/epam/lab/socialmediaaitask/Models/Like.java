package com.epam.lab.socialmediaaitask.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Like {

    private Long id;

    private User user;

    private Post post;
}