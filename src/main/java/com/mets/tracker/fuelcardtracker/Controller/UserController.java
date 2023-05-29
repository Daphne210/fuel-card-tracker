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

    @RequestMapping("/home")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginUser.html");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerUser.html");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") User user, ModelMap model){
        userService.saveDetails(user);
        List<User> users = userService.getAllUserDetails();
        model.addAttribute("users",users);
        ModelAndView modelAndView = new ModelAndView("indexUser.html",model);
        return modelAndView;
    }

    @RequestMapping(value="/index")
    public ModelAndView index(ModelMap model)
    {
        List<User> users = userService.getAllUserDetails();
        model.addAttribute("users",users);
        return new ModelAndView("/indexUser.html",model);
    }

    @RequestMapping(value="/editUser/{userID}")
    public ModelAndView showEditUser(@PathVariable(name = "userID") Long userID, ModelMap model){
        User users = userService.getUserDetails(userID);
        ModelAndView modelAndView = new ModelAndView("editUser.html", model);
        model.addAttribute("users", users);
        return modelAndView;
    }

    @RequestMapping("/deleteUser/{userID}")
    public ModelAndView deleteUser(@PathVariable Long userID, ModelMap model){
        userService.deleteDetails(userID);
        List<User> users = userService.getAllUserDetails();
        model.addAttribute("users",users);
        ModelAndView modelAndView = new ModelAndView("indexUser.html", model);
        return modelAndView;
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
