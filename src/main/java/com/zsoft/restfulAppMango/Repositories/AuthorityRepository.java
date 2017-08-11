package com.zsoft.restfulAppMango.Repositories;

import com.zsoft.restfulAppMango.domaine.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Authority entity.
 */
public interface AuthorityRepository extends MongoRepository<Authority, String> {
}
