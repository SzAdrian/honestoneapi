package com.codecool.honestoneapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usr {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    @JsonIgnore
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    @JsonIgnore
    private LocalDateTime registrationTime;

    @Singular
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Deck> decks;

    @ElementCollection
    @Singular
    @NotEmpty
    @JsonIgnore
    private Set<Role> roles;

    @ElementCollection
    @Singular
    private Set<Long> likedDecks;

    @ElementCollection
    @Singular
    private Set<Long> dislikedDecks;
}
