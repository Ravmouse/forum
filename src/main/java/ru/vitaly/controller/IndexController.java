package ru.vitaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vitaly.service.PostService;

/**
 * @author Vitaly Vasilyev, date: 02.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
public class IndexController {

    private PostService service;

    @Autowired
    public IndexController(PostService service) {
        this.service = service;
    }

    @GetMapping("/main")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        model.addObject("posts", service.getAll());
        return model;
    }
}