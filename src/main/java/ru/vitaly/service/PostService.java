package ru.vitaly.service;

import org.springframework.stereotype.Service;
import ru.vitaly.entity.Post;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vitaly Vasilyev, date: 02.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Service
public class PostService {

    private final List<Post> posts = Arrays.asList(
            new Post("Урожай на моем участке", "В прошлом году мне удалось вырастить 100 кг картофеля"),
            new Post("Баня", "Эту баню я построил своими руками")
    );

    public List<Post> getAll() {
        return posts;
    }
}