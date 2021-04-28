package com.salary.app.repositories;

import com.salary.app.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    @Query("SELECT salary FROM Salary salary WHERE salary.name=:name")
    Salary getSalaryByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Salary salary SET salary.monthlySalary=:monthlySalary WHERE salary.id=:id")
    void updateMonthlySalary(@Param("id") Long id, @Param("monthlySalary") Long monthlySalary);
}
