package com.zsoft.restfulAppMango.Repositories;

import com.zsoft.restfulAppMango.domaine.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Syphax on 10/08/2017.
 */
public interface UserRepository extends MongoRepository<User,String>{
    Optional<User> findByLoginEquals(String login);
}