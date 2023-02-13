package com.esprit.tn.pidev.services;


import com.esprit.tn.pidev.entities.Event;
import com.esprit.tn.pidev.repositories.EventRepository;
import com.esprit.tn.pidev.repositories.ParticipantRepository;
import com.esprit.tn.pidev.repositories.UserRepository;


import com.google.api.services.calendar.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventService implements EventS {


    private Calendar calendar;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParticipantRepository participantRepository;



    public Event createEvent(Event event)  {
            return eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEvent(Long eventId)  {
        return eventRepository.findById(eventId);
    }

    @Override
    public List<Event> getAllEvent()  {
        return eventRepository.findAll();
    }

    @Override
    public Event updateEvent(Event event)  {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(String eventId)  {
        eventRepository.deleteById(Long.valueOf(eventId));
    }


}