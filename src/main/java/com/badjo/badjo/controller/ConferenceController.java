package com.badjo.badjo.controller;

import java.util.List;
import java.util.Optional;

import com.badjo.badjo.services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.badjo.badjo.domain.models.Conference;
import com.badjo.badjo.services.ConferenceServices;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {
    private final ConferenceServices conferenceService;
    @Autowired
    ConferenceController(ConferenceServices conferenceService){
        this.conferenceService = conferenceService;
    }

    @PostMapping
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        Conference savedConference = conferenceService.saveConference(conference);
        return new ResponseEntity<>(savedConference, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Conference>> getAllConferences() {
        List<Conference> conferences = conferenceService.getAllConferences();
        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable("id") Long id) {
        Optional<Conference> conference = conferenceService.getConferenceById(id);
        return conference.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }
}
