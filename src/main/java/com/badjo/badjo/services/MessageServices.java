package com.badjo.badjo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badjo.badjo.domain.models.Message;
import com.badjo.badjo.domain.repository.MessageRepository;

@Service
public class MessageServices {
    private final MessageRepository messageRepository;
    @Autowired
    MessageServices(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
    public Iterable<Message> getAllMessage(){
        return messageRepository.findAll();
    }
}
