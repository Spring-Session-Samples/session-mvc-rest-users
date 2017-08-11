

package sample.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rudra.aks.user.UserBO;


/**
 * @author Ankush.Verman
 */
@Controller
public class RestDemoController {

	@Autowired
	SessionSerivce	service;
	private static final Logger logger = Logger.getLogger(RestDemoController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userForm", new UserBO());
        return "login";
    }
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("userForm") UserBO userForm, HttpSession session, BindingResult bindingResult, Model model, HttpServletRequest req, HttpServletResponse res) {
		logger.info("Start : " + getClass().getName() + " login()");
		req.getSession().setAttribute("username", userForm.getUsername());
		req.getSession().setAttribute("username", req.getParameter("username"));
		session.setAttribute("username", userForm.getUsername());
		logger.info("End : " + getClass().getName() + " helloUser()");
		return "index";
	}

	@RequestMapping("/logout")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String logout(HttpSession session) {
		logger.info("Logging out current user...");
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String testRest() {
		return "index";
	}
}
