package com.crowdfunding.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crowdfunding.dto.ProjectDTO;

public interface ProjectService {
	ProjectDTO createProject(ProjectDTO projectDTO);

	ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO);

	boolean deleteProject(Long projectId);

	ProjectDTO getProjectById(Long projectId);

	Page<ProjectDTO> getAllProjects(Pageable pageable);
}
