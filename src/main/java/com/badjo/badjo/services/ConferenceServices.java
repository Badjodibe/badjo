package com.badjo.badjo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badjo.badjo.domain.models.Conference;
import com.badjo.badjo.domain.repository.ConferenceRepository;

@Service
public class ConferenceServices {


    private final ConferenceRepository conferenceRepository;
    @Autowired
    ConferenceServices(ConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
    }

    public Conference saveConference(Conference conference) {

        return conferenceRepository.save(conference);
    }

    public List<Conference> getAllConferences() {
        return (List<Conference>) conferenceRepository.findAll();
    }

    public Optional<Conference> getConferenceById(Long id) {
        return conferenceRepository.findById(id);
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }
}
