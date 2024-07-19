package com.badjo.badjo.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.badjo.badjo.domain.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
