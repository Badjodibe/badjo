package com.badjo.badjo.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.badjo.badjo.domain.models.Conference;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {
}
