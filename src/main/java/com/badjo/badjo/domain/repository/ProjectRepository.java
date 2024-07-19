package com.badjo.badjo.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.badjo.badjo.domain.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
