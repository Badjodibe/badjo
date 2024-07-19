package com.badjo.badjo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.badjo.badjo.domain.models.Message;
import com.badjo.badjo.services.MessageServices;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/messages")
@Validated
public class MessageController {

    private final MessageServices messageService;
    @Autowired
    MessageController(MessageServices messageService){
        this.messageService = messageService;
    }
    @PostMapping
    public ResponseEntity<String> sendMessage(@Valid @RequestBody Message message) {
        messageService.saveMessage(message);
        return new ResponseEntity<>("Message reçu avec succès", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Message>> getMessages(){
        Iterable<Message> messages = messageService.getAllMessage();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
