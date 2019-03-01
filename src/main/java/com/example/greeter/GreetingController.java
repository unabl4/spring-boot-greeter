package com.example.greeter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET, produces = "text/plain")
//    @ResponseBody
    public String greetingAdvanced(@PathVariable String name) {
//        return Collections.singletonMap("response", name);
        return "greeting_advanced";
    }
}