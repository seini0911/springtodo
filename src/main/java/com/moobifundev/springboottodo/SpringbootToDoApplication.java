package com.moobifundev.springboottodo;

import com.moobifundev.springboottodo.model.Todo;
import com.moobifundev.springboottodo.model.User;
import com.moobifundev.springboottodo.repository.TodoRepository;
import com.moobifundev.springboottodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SpringbootToDoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootToDoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Todo todo = Todo.builder()
				.content("first task")
				.completed(false)
				.build();

		User user = User.builder()
				.userName("Seini")
				.password("seini@password")
				.build();
		user.getTodoList().add(todo);

		userRepository.save(user);
		todoRepository.save(todo);
	}
}
