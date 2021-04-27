package com.salary.app.repositories;

import com.salary.app.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    @Query("SELECT salary FROM Salary salary WHERE salary.name=:name")
    Salary getSalaryByName(@Param("name") String name);
}
