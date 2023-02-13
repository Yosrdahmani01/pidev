package com.esprit.tn.pidev.services;


import com.esprit.tn.pidev.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventS {
    Event createEvent(Event event) ;
    Optional<Event> getEvent(Long eventId) ;

    List<Event> getAllEvent();
    Event updateEvent(Event event);
    void deleteEvent(String eventId) ;
}