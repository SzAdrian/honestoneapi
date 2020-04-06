package com.codecool.honestoneapi.model;

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
    private String email;

    @NotBlank
    private String password;

    private LocalDateTime registrationTime;

    @Singular
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Deck> decks;

    @ElementCollection
    @Singular
    @NotEmpty
    private Set<Role> roles;

    public void addDeck(Deck deck){
        deck.setUser(this);
        decks.add(deck);
    }
}
