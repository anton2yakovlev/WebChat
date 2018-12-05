package the_biber_project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import the_biber_project.User;
import the_biber_project.repos.MemRepInMemoryMessageRepository;
//import org.springframework.in

@Controller
public class MainController {

    MemRepInMemoryMessageRepository usrs = new MemRepInMemoryMessageRepository();



    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");

        if (username == null || username.isEmpty()) {
            return "redirect:/login";
        }

        model.addAttribute("username", username);
        User s = new User();
        s.setUserName(username);
        usrs.save(s);

        model.addAttribute("users", usrs.usersStr);

        System.out.println(usrs.findAll().toString());


        return "chat";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
        username = username.trim();

        if (username.isEmpty()) {
            return "login";
        }
        request.getSession().setAttribute("username", username);



        return "redirect:/";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();


        return "redirect:/login";
    }

}