package com.example.springcrac;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Attendee {

    public static Attendee newAttendee(String name, Set<String> technologies) {
        return new Attendee(null, name, technologies);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "attendee_technologies", joinColumns = @JoinColumn(name = "attendee_id"))
    @Column(name = "technology")
    private Set<String> technologies = new LinkedHashSet<>();

    /**
     * required by JPA
     */
    @Deprecated
    public Attendee() {
    }

    public Attendee(Long id, String name, Set<String> technologies) {
        this.id = id;
        this.name = name;
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getTechnologies() {
        return technologies;
    }
}
