package com.zsoft.restfulAppMango.Repositories;

import com.zsoft.restfulAppMango.domaine.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Syphax on 08/08/2017.
 */
public interface StudentsRepository extends MongoRepository<Student, String> {

    Optional<Student> getStudentByNomEqualsAndPrenomEquals(String nom, String prenom);
}
