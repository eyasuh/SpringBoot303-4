package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TodoList {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		@NotNull
		@Size(min = 2)
		private String taskName;

		@NotNull
		@Size(min = 2)
		private String dueDate;

		@NotNull
		@Size(min = 2)
		private String priority;

		public TodoList() {
		}

	public TodoList(@NotNull @Size(min = 2) String taskName, @NotNull @Size(min = 2) String dueDate, @NotNull @Size(min = 2) String priority) {
		this.taskName = taskName;
		this.dueDate = dueDate;
		this.priority = priority;
	}

	public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTaskName() {
			return taskName;
		}

		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}

		public String getDueDate() {
			return dueDate;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}
}
