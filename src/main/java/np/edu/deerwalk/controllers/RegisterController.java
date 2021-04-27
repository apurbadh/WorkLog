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
public class RegisterController {
	
	@Autowired
	private UserRepository userdb;
	
	@GetMapping("register")
	ModelAndView doGet(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		if (session.getAttribute("isLogged") != null) {
			return new ModelAndView("redirect:/");
		}
		session.setAttribute("logMes", "");
		mv.addObject("mes", session.getAttribute("regMes") == null ? "" : session.getAttribute("regMes"));
		return mv;
	}
	
	@PostMapping("register")
	String doPost(UserModel user, HttpSession session) {
		List<UserModel> usrnm = userdb.findByUsername(user.getUsername());
		List<UserModel> email = userdb.findByEmail(user.getEmail());
		
		if (usrnm.isEmpty() && email.isEmpty()) {
			userdb.save(user);
			session.setAttribute("regMes", "User has been registered");
		}else {
			session.setAttribute("regMes", "User already exists");
		}
		
		return "redirect:/register";
	}

}
