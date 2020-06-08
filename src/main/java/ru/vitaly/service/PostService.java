package ru.vitaly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.entity.Post;
import ru.vitaly.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitaly Vasilyev, date: 02.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Service
public class PostService {

    private PostRepository posts;

    @Autowired
    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        final List<Post> list = new ArrayList<>();
        posts.findAll().forEach(list::add);
        return list;
    }

    public Post getPostById(int id) {
        return posts.findById(id).get();
    }

    public void addPost(Post post) {
        posts.save(post);
    }
}