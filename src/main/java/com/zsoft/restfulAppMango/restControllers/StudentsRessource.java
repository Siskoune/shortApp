package com.zsoft.restfulAppMango.restControllers;

import com.zsoft.restfulAppMango.Repositories.StudentsRepository;
import com.zsoft.restfulAppMango.Repositories.TeachersRepository;
import com.zsoft.restfulAppMango.domaine.Student;
import com.zsoft.restfulAppMango.domaine.Teacher;
import oracle.jrockit.jfr.StringConstantPool;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Syphax on 08/08/2017.
 */
@RestController
@RequestMapping("/students")
public class StudentsRessource {
    private StudentsRepository studentsRep;
    private TeachersRepository teachersRep;
    public StudentsRessource(StudentsRepository studentsRep, TeachersRepository teachersRep) {
        this.studentsRep = studentsRep;
        this.teachersRep= teachersRep;
    }

    @GetMapping
    String get() {
        List<Student> ll=studentsRep.findAll();
        if (!ll.isEmpty()){
            Iterator<Student> iterateur=ll.iterator();
            String laListeDesEtudiants="";
            while(iterateur.hasNext()) laListeDesEtudiants+=iterateur.next().toString();
            return laListeDesEtudiants;
        }
        else return "\n\n\n \t\t liste vide";
    }
    @PostMapping
    String create(@RequestParam(name="nom")String nom, @RequestParam(name="prenom")String prenom){
        Student std=new Student();
        std.setNom(nom);
        std.setPrenom(prenom);
        Teacher tea=new Teacher();
        tea.setNom("chikh");
        tea.setPrenom("chikha");
        //tea.setStudents(Collections.singleton(std));
        //std.setTeachers(Collections.singleton(tea));
        studentsRep.save(std);
        teachersRep.save(tea);
        //pour généraliser ca __ On va devoir a chaque fois quon veux ajouter un student avec un nombre de professeur differfents
        // on cree le student vide
        //on cherche si les teacher existe sion on les crée et on les rasemble tous dans une collection et save le changement pour le student
        // on doit egalment updater la liste des eleves de chaque teacher par un ajout dans la liste
        // win rahi la coherence hnaya rien ?? aucune gestion de la coherence semma wella kifeh
        Optional<Student> student = studentsRep.getStudentByNomEqualsAndPrenomEquals(nom, prenom);
        Teacher teacher = teachersRep.getStudentByNomEqualsAndPrenomEquals("chikh", "chikha");
        student.ifPresent(s -> {
            s.setTeachers(Collections.singleton(teacher));
            studentsRep.save(s);
            teacher.setStudents(Collections.singleton(s));
            teachersRep.save(teacher);
        });
        return "Etudiant cree";
    }

    @PutMapping
    void update(@RequestParam(name="nom")String nom, @RequestParam(name="prenom")String prenom, @RequestParam(name="nouveau_prenom")String nouveauPrenom){
        Optional<Student> student = studentsRep.getStudentByNomEqualsAndPrenomEquals(nom, prenom);
        student.ifPresent(s -> {
            s.setPrenom(nouveauPrenom);
            studentsRep.save(s);
        });
    }

}
