package ru.vitaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.vitaly.service.PostService;

/**
 * @author Vitaly Vasilyev, date: 04.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
public class PostController {

    private PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/post/{id}/details")
    public ModelAndView getPost(@PathVariable("id") int id, ModelAndView model) {
        model.setViewName("post");
        model.addObject("post", service.getPostById(id));
        return model;
    }
}