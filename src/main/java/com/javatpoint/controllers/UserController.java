package com.javatpoint.controllers;

import com.javatpoint.beans.User;
import com.javatpoint.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao dao;

    @RequestMapping("/login")
    public String showForm(Model m){
        m.addAttribute("command", new User());
        return "login";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        dao.save(user);
        return "redirect:/viewuser";
    }

    @RequestMapping(value = "/viewuser")
    public String viewuser(Model m) {
        List<User> list = dao.getUsers();
        m.addAttribute("list", list);
        return "viewuser";
    }

    @RequestMapping(value = "/edituser/{id}")
    public String edit(@PathVariable int id, Model m) {
        User user = dao.getUserById(id);
        m.addAttribute("command", user);
        return "usereditform";
    }

    @RequestMapping(value = "/editusersave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("user") User user) {
        dao.update(user);
        return "redirect:/viewuser";
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewuser";
    }
}
