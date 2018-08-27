package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByUser(User user);
    List<Tweet> findAllByUserId(Long id);
    List<Tweet> findAllByUserIdOrderByCreatedDesc(Long id);
    @Query(value = "select * from tweet  order by created desc limit 6", nativeQuery = true)
    List<Tweet> findAllOrderByCreatedDesc();

}
