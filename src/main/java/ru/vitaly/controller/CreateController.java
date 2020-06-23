package ru.vitaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.vitaly.entity.Post;
import ru.vitaly.entity.User;
import ru.vitaly.service.PostService;
import ru.vitaly.service.UserService;
import java.io.IOException;

/**
 * @author Vitaly Vasilyev, date: 04.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
public class CreateController {

    private PostService service;
    private UserService userService;

    @Autowired
    public CreateController(PostService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String show() {
        return "create";
    }

    @PostMapping("/create/savepost")
    public RedirectView create(@ModelAttribute("the_Post") Post post) throws IOException {
        User user = userService.findById(1);
        post.setUser(user);
        service.addPost(post);
        return new RedirectView("/main", true);
    }
}