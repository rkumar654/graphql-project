package com.mrk.graphql.quary.componets;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrk.graphql.entites.Project;
import com.mrk.graphql.repository.ProjectRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
@Transactional
public class ProjectMutation implements GraphQLMutationResolver {

	@Autowired
	private ProjectRepository projectRepository;

	public Project createProject(Project project) {
		return this.projectRepository.save(project);
	}
}
