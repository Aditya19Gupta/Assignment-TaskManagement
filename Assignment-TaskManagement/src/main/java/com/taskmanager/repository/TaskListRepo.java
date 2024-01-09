package com.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taskmanager.entities.TaskList;
import com.taskmanager.entities.User;

@Repository
public interface TaskListRepo extends JpaRepository<TaskList, Integer>{
	@Query("select l from TaskList l where l.user= :user")
	public List<TaskList> getTaskListByUser(@Param("user") User user);
	
}
