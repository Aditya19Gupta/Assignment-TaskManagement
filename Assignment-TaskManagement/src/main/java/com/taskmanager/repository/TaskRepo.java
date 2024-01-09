package com.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taskmanager.entities.Task;
import com.taskmanager.entities.TaskList;
import com.taskmanager.entities.User;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

	
}
