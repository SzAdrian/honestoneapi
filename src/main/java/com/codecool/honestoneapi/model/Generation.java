package com.codecool.honestoneapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Generation {

    @Id
    @GeneratedValue
    private long id;

    private long deck_id;

    private long statistics_id;

    private long generation_count;
}
