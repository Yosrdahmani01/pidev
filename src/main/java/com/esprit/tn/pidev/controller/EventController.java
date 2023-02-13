package com.esprit.tn.pidev.controller;

import com.esprit.tn.pidev.entities.Event;
import com.esprit.tn.pidev.entities.Participant;
import com.esprit.tn.pidev.entities.User;
import com.esprit.tn.pidev.repositories.UserRepository;
import com.esprit.tn.pidev.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;
    private UserRepository userRepository;
    public EventController(EventService eventService , UserRepository userRepository) {
        this.eventService = eventService;
        this.userRepository= userRepository;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event)  {
        Collection<User> users = userRepository.findAll();
        List<Participant> participantList= new ArrayList<Participant>();
        for(User user:users){
            participantList.add(new Participant(user,event));
        }

        event.setParticipants(
                participantList);
        return eventService.createEvent(event);
    }
    @GetMapping
    public List<Event> getAllEvent() {
        return eventService.getAllEvent();
    }

    @GetMapping("/{eventId}")
    public Optional<Event> getEvent(@PathVariable("eventId") Long eventId) throws IOException {
        return eventService.getEvent(Long.valueOf(eventId));
    }

    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable("eventId") String eventId, @RequestBody Event event) throws IOException {
        event.setId(Long.valueOf(eventId));
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable("eventId") String eventId)  {
        eventService.deleteEvent(eventId);
    }

    }
