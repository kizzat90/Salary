package com.salary.app.controller;

import com.salary.app.service.SalaryService;
import com.salary.app.util.CustomErrorMessage;
import com.salary.app.util.CustomMessage;
import com.salary.app.util.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping(name = "getTaxPayableByName", method = RequestMethod.GET)
    public ResponseEntity<CustomMessage> getTaxPayableByName(@RequestParam("name") String name) throws CustomErrorMessage {
        try {
            Regex.getInstance().validateName(name);
            return new ResponseEntity<>(salaryService.getTaxPayableByName(name), HttpStatus.OK);
        } catch (Exception exception) {
            throw new CustomErrorMessage(HttpStatus.OK, exception.getMessage(), "Unable to get Tax Payable by name");
        }
    }

    @RequestMapping(name = "updateMonthlySalary", method = RequestMethod.POST)
    public ResponseEntity<CustomMessage> updateMonthlySalary(@RequestParam("id") Long id, @RequestParam("monthlySalary") Long monthlySalary) throws CustomErrorMessage {
        try {
            Regex.getInstance().validateWholeNumber(monthlySalary);
            return new ResponseEntity<>(salaryService.updateMonthlySalary(id, monthlySalary), HttpStatus.OK);
        } catch (Exception exception) {
            throw new CustomErrorMessage(HttpStatus.OK, exception.getMessage(), "Unable to update monthly salary");
        }
    }
}
