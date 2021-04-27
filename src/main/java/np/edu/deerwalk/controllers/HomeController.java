package np.edu.deerwalk.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import np.edu.deerwalk.models.UserModel;
import np.edu.deerwalk.repositories.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userdb;
	
	@GetMapping
	ModelAndView doGet(HttpSession session) {
		session.setAttribute("createMes", "");
		session.setAttribute("logMes", "");
		ModelAndView mv = new ModelAndView("index.jsp");
		if (session.getAttribute("isLogged") == null) {
			return new ModelAndView("redirect:/login");
		}
		UserModel user_temp = (UserModel) session.getAttribute("user");
		UserModel user = userdb.findByUsername(user_temp.getUsername()).get(0);
		mv.addObject("logs", user.getLogs());
		return mv;
	}

}
