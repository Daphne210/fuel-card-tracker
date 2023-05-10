package com.mets.tracker.fuelcardtracker.Controller;

import com.mets.tracker.fuelcardtracker.Entity.User;
import com.mets.tracker.fuelcardtracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@ControllerAdvice
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register.html");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") User user, ModelMap model){
        userService.saveDetails(user);
        ModelAndView modelAndView = new ModelAndView("login.html",model);
        return modelAndView;
    }

    @RequestMapping(value="/home")
    public ModelAndView index(ModelMap model)
    {
        List<User> users = userService.getAllUserDetails();
        model.addAttribute("users",users);

        return new ModelAndView("/index.html",model);
    }

    @GetMapping("/getUser")
    public List<User> getAllUserDetails(){
        return userService.getAllUserDetails();
    }

    @GetMapping("/getUser/{userID}")
    public User fetchUser(@PathVariable Long userID){
        return userService.getUserDetails(userID);
    }

    @PostMapping("/addUser")
    public User addNewUser(@RequestBody User user){
        return userService.saveDetails(user);
    }

    @DeleteMapping("/deleteUser/{userID}")
    public String deleteUser(@PathVariable Long userID){
        return userService.deleteDetails(userID);
    }
}
