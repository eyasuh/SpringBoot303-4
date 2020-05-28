package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	TodoListRepository todoListRepository;

	//make the data available for view with var name "todoList" from todoListRepository
	//will show list of entries
	@RequestMapping("/")
	public String listTodoList(Model model){
		model.addAttribute("todoLists", todoListRepository.findAll());
		return "list";
	}
	//pass new instance of TodoList to the view which will hold all values of user entries
	//then pass the values to the post method routed
	@GetMapping("/add")
	public String todoListForm(Model model) {
		model.addAttribute("todoList", new TodoList());
		return "todoListform";
	}

	//validate for errors, save TodoList object in database using the Autowired repository
	//then redirect to default (@RequestMapping)
	@PostMapping("/process")
	public String pprocessForm(@Valid TodoList todoList, BindingResult result) {
		if(result.hasErrors())
			return "todoListform";
		todoListRepository.save(todoList);
		return "redirect:/";
	}

	//display in show page
	@RequestMapping("/detail/{id}")
	public String showTodoList(@PathVariable("id") long id, Model model) {
		model.addAttribute("todoList", todoListRepository.findById(id).get());
		return "show";
	}

	//
	@RequestMapping("/update/{id}")
	public String updateTodoList(@PathVariable("id") long id , Model model) {
		model.addAttribute("todoList", todoListRepository.findById(id).get());
		return "todoListform";
	}

	//after deleting show entire list
	@RequestMapping("/delete/{id}")
	public String deleteTodoList(@PathVariable("id") long id) {
		todoListRepository.deleteById(id);
		return "redirect:/";
	}

}
















