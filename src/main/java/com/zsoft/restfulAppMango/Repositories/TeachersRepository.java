package com.zsoft.restfulAppMango.Repositories;

import com.zsoft.restfulAppMango.domaine.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Syphax on 08/08/2017.
 */
public interface TeachersRepository extends MongoRepository<Teacher, String>{
    Teacher getStudentByNomEqualsAndPrenomEquals(String nom, String prenom);
}
