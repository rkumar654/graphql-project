package com.mrk.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrk.graphql.entites.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{

}
