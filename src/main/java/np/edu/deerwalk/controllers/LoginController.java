package np.edu.deerwalk.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import np.edu.deerwalk.models.UserModel;
import np.edu.deerwalk.repositories.UserRepository;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userdb;
	
	@GetMapping("login")
	ModelAndView doGet(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		session.setAttribute("resMes", "");
		mv.setViewName("login.jsp");
		if (session.getAttribute("isLogged") != null) {
			return new ModelAndView("redirect:/");
		}
		mv.addObject("mes", session.getAttribute("logMes") == null ? "" : session.getAttribute("logMes"));
		return mv;
	}
	
	@PostMapping("login")
	String doPost(String username, String password, HttpSession session) {
		List<UserModel> userList = userdb.findByUsername(username);
		
		if (userList.isEmpty()) {
			session.setAttribute("logMes", "User does not exist");
		} else if (!(userList.get(0).getPassword().equals(password))) {
			session.setAttribute("logMes", "Incorrect Password");
		}else {
			UserModel user = userList.get(0);
			session.setAttribute("user", user);
			session.setAttribute("isLogged", true);
			return "redirect:/";
		}
		return "redirect:/login";
		
	}

}
