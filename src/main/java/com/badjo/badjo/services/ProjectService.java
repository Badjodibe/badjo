package com.badjo.badjo.services;

import java.util.List;
import java.util.Optional;

import com.badjo.badjo.domain.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badjo.badjo.domain.models.Project;
import  com.badjo.badjo.domain.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    @Autowired
    ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
