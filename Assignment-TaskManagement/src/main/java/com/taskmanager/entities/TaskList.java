package com.taskmanager.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskList {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int tlid;
	private String taskListName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Task> taskList;
	
	@ManyToOne
	@JoinColumn(name = "id")
	User user;

}
