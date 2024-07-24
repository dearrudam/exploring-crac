package com.example.springcrac;

import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/jconfbr")
public class Endpoints {

    private final Conference conference;

    public Endpoints(Conference conference) {
        this.conference = conference;
    }

    record RegisteredAttendee(Long id, String name, Set<String> technologies) {
        static RegisteredAttendee of(Attendee attendee) {
            return new RegisteredAttendee(attendee.getId(), attendee.getName(), attendee.getTechnologies());
        }
    }

    @GetMapping("/attendees")
    List<RegisteredAttendee> listAll(){
        return conference.findAll().stream().map(RegisteredAttendee::of).toList();
    }
}
