package ru.vitaly.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vitaly.entity.Post;

/**
 * @author Vitaly Vasilyev, date: 03.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}