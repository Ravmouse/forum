package ru.vitaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.vitaly.entity.Post;
import ru.vitaly.service.PostService;

/**
 * @author Vitaly Vasilyev, date: 04.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
public class CreateController {

    private PostService service;

    @Autowired
    public CreateController(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String show(ModelAndView model) {
        model.setViewName("edit");
        return "edit";
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("post") Post post) {
        service.addPost(post);
        return new RedirectView("/main", true);
    }
}