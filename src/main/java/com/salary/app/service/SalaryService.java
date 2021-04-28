package com.salary.app.service;

import com.salary.app.model.Salary;
import com.salary.app.repositories.SalaryRepository;
import com.salary.app.util.CustomMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalaryService {
    @Resource
    private SalaryRepository salaryRepository;

    public CustomMessage getTaxPayableByName(String name) throws Exception {
        Salary salary;
        if (salaryRepository.getSalaryByName(name) != null) {
            salary = salaryRepository.getSalaryByName(name);
        } else {
            throw new Exception(name + " doesn't exist");
        }

        int yearlySalary = this.calculateYearlySalary(salary.getMonthlySalary());
        int taxPayable = this.calculateTaxPayable(yearlySalary);

        return new CustomMessage(name, yearlySalary * 100, taxPayable);
    }

    private int calculateYearlySalary(Long monthlySalary) {
        return monthlySalary.intValue() * 12;
    }

    private int calculateTaxPayable(Integer yearlySalary) {
        double rate = 0.0;

        if (yearlySalary >= 0 && yearlySalary <= 5000) {
            return 0;
        } else if (yearlySalary >= 5001 && yearlySalary <= 20000) {
            rate = 0 + ((yearlySalary - 5000) * 0.01);
        } else if (yearlySalary >= 20001 && yearlySalary <= 35000) {
            rate = 150 + ((yearlySalary - 20000) * 0.03);
        } else if (yearlySalary >= 35001 && yearlySalary <= 50000) {
            rate = 600 + ((yearlySalary - 35000) * 0.08);
        } else if (yearlySalary >= 50001 && yearlySalary <= 70000) {
            rate = 1800 + ((yearlySalary - 50000) * 0.14);
        } else if (yearlySalary >= 70001 && yearlySalary <= 100000) {
            rate = 4600 + ((yearlySalary - 70000) * 0.21);
        } else if (yearlySalary >= 100001 && yearlySalary <= 250000) {
            rate = 10900 + ((yearlySalary - 100000) * 0.24);
        } else if (yearlySalary >= 250001 && yearlySalary <= 400000) {
            rate = 46900 + ((yearlySalary - 250000) * 0.245);
        } else if (yearlySalary >= 400001 && yearlySalary <= 600000) {
            rate = 83650 + ((yearlySalary - 400000) * 0.25);
        }
        return (int) rate * 100;
    }

    public CustomMessage updateMonthlySalary(Long id, Long monthlySalary) throws Exception {
        Salary salary;
        if (!salaryRepository.findById(id).isPresent()) {
            throw new Exception("Id " + id + " is not valid");
        }
        salaryRepository.updateMonthlySalary(id, monthlySalary);
        salary = salaryRepository.findById(id).get();
        return new CustomMessage(salary.getName(), salary.getMonthlySalary().intValue());
    }
}
