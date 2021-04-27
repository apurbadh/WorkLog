package np.edu.deerwalk.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	@GetMapping("logout")
	String doGet(HttpSession session) {
		session.setAttribute("isLogged", null);
		return "redirect:/";
	}

}
