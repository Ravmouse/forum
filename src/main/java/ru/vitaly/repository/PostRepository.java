package ru.vitaly.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vitaly.entity.Post;

/**
 * @author Vitaly Vasilyev, date: 03.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public interface PostRepository extends CrudRepository<Post, Integer> {

}