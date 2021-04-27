package np.edu.deerwalk.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import np.edu.deerwalk.models.LogModel;
import np.edu.deerwalk.models.UserModel;
import np.edu.deerwalk.repositories.LogRepository;
import np.edu.deerwalk.repositories.UserRepository;

@Controller
public class CreateController {
	
	@Autowired
	private UserRepository userdb;
	@Autowired
	private LogRepository logdb;
	
	@GetMapping("/create")
	ModelAndView doGet(HttpSession session) {
		if (session.getAttribute("isLogged") == null) {
			return new ModelAndView("redirect:/login");
		}
		
		UserModel currentUser = (UserModel) session.getAttribute("user");
		List<UserModel> users = userdb.findAll();
		String[] userArray = {};
		String theusr = currentUser.getUsername();

		for (UserModel user : users) {
			if (theusr.equals(user.getUsername())) {
				continue;
			}
			userArray = Arrays.copyOf(userArray, userArray.length + 1);
			userArray[userArray.length - 1] = user.getUsername();
		}
		
		ModelAndView mv = new ModelAndView("create.jsp");
		mv.addObject("users", userArray);
		mv.addObject("createMes", session.getAttribute("createMes"));
		return mv;
	}
	
	@PostMapping("/create")
	String doPost(String name, String[] users, HttpSession session) 
	{
		if (logdb.findByName(name).isEmpty()) {
			session.setAttribute("createMes", "");
			UserModel currentUser = (UserModel) session.getAttribute("user");
			users = Arrays.copyOf(users, users.length + 1);
			users[users.length - 1] = currentUser.getUsername();
		
			LogModel log = new LogModel();
			String logs[][] = {};
			for (String user : users) {
				UserModel theuser = userdb.findByUsername(user).get(0);
			theuser.appendLog(name);
			userdb.save(theuser);
			}
			log.setName(name);
			log.setLogs(logs);
			logdb.save(log);
			return "redirect:/";
		}
		session.setAttribute("createMes", "Log of that name exists");
		return "redirect:/create";
	}

}
