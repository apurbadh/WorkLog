package np.edu.deerwalk.controllers;


import java.util.Arrays;

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
public class LogController {
	
	public String[][] reverseArray(String[][] array){
		String[][] answer = {};
		for (int i = array.length - 1; i  >  -1; i--) {
			answer = Arrays.copyOf(answer, answer.length + 1);
			answer[answer.length - 1] = array[i];
		}
		
		return answer;
	}
	
	@Autowired
	private LogRepository logdb;
	@Autowired
	private UserRepository userdb;
	
	@GetMapping(value = "/log")
	ModelAndView doGet(String name, HttpSession session) {
		
		session.setAttribute("name", name);
		if (logdb.findByName(name).isEmpty()) {
			return new ModelAndView("redirect:/");
		}
		if (session.getAttribute("isLogged") == null) {
			return new ModelAndView("redirect:/login");
		}
		UserModel usr = (UserModel) session.getAttribute("user");
		usr = userdb.findByUsername(usr.getUsername()).get(0);
		if (!Arrays.asList(usr.getLogs()).contains(name)) {
			return new ModelAndView("redirect:/");
		}
		LogModel log = logdb.findByName(name).get(0);
		String[][] messages = log.getLogs();
		ModelAndView mv = new ModelAndView("log.jsp");
		messages = reverseArray(messages);
		mv.addObject("messages", messages);
		mv.addObject("name", name);
		return mv;
	}
	
	@PostMapping("/log")
	String doPost(String message, HttpSession session) {
		LogModel log = logdb.findByName((String)session.getAttribute("name")).get(0);
		UserModel user = (UserModel) session.getAttribute("user");
		String[] toadd = {user.getFname(), message};
		log.appendLog(toadd);
		logdb.save(log);
	    return "redirect:/log?name="+ session.getAttribute("name");
	}

}
