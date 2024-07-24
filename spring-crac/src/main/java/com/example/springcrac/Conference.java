package com.example.springcrac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Conference extends JpaRepository<Attendee, Long> {

}
