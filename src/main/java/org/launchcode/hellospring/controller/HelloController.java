package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
//    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name,Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Meera");
        names.add("Deepa");
        names.add("Sajeesh");
        model.addAttribute("names",names);
        return "hello-list";
    }


    @GetMapping("form")
    public String helloUserForm() {
        return "form";
    }
//Exercise for chapter 10 is below
    @RequestMapping(value="helloUser", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {

        if (name == null) {
            name = "World";
        }
        return language +" "+  name;
       // return createMessage(name, language);
    }
    public static String createMessage(String name, String l){
        System.out.println("Inside createmessage "+l);
        String greeting = "";
        if (l.equals("English")) {
            greeting = "Hello";
        }
        else if (l.equals("French")) {
            greeting = "Bonjour";
        }
        else if (l.equals("Italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("German")) {
            greeting = "Hallo";
        }

        return greeting + " " + name;
    }
    @GetMapping("form")
    @ResponseBody
    @RequestMapping("helloUser")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'helloUser' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select id ='language' name ='language'>"+
                "<option value ='Hello'>English</option>"+
                "<option value ='Bonjour'>French</option>" +
                "<option value ='Bonjourno'>Italian</option>"+
                "<option value ='Hola'>Spanish</option>"+
                "<option value ='Hallo'>German</option>"+
                "</select>"+
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
