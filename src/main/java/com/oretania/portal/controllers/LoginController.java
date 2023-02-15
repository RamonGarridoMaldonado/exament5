package com.oretania.portal.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = { "/welcome" })
    public String welcome() {

        return "welcome";
    }

    @GetMapping(value = {"/matematicas"})
    public String matematicas() {
        return "matematicas";
    }

    @GetMapping(value = {"/lengua"})
    public String lengua() {
        return "lengua";
    }


    @GetMapping(value = {"/ingles"})
    public String ingles() {
        return "ingles";
    }

    @GetMapping(value = {"/fisica"})
    public String fisica() {
        return "fisica";
    }

    @GetMapping(value = {"/quimica"})
    public String quimica() {
        return "quimica";
    }

}