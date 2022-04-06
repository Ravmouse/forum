package ru.vitaly.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.vitaly.entity.Post;
import java.util.List;

/**
 * @author Vitaly Vasilyev, e-mail: rav.energ@rambler.ru
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query("select p from Post p join fetch p.user u")
    List<Post> findAllPosts();
}