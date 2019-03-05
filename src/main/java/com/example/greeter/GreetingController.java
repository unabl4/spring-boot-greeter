package com.example.greeter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/greetingMap")
    public String greetingMap(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET, produces = "text/plain")
//    @ResponseBody
    public String greetingName(@PathVariable String name) {
//        return Collections.singletonMap("response", name);
        return "greeting_name";
    }

    @GetMapping("/greetingHash")
    @ResponseBody
    public HashMap<String, Object> greetingHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        return map;
    }

    @GetMapping("/greetingPojo")
    @ResponseBody
    public Person greetingPojo(@RequestParam(name="name", required=false) String name) {
        name = (name == null || name.isEmpty()) ? "stranger" : name;    // fallback to 'stranger'

        Person person = new Person();   // person to greet
        person.setName(name);
        return person;
    }

    @GetMapping("/greetingPojo/{name}")
    @ResponseBody
    public Person greetingPojoName(@PathVariable(name="name") String name) {
        Person person = new Person();   // person to greet
        person.setName(name);
        return person;
    }
}