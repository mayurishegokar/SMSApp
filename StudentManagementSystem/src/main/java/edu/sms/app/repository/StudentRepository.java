package edu.sms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.sms.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
