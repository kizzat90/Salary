package com.salary.app.util;

import org.springframework.http.HttpStatus;

public class CustomMessage {
    private String name;
    private int salary;
    private int tax_payable;
    private HttpStatus httpStatus;

    private CustomMessage() {}

    public CustomMessage(String name, int salary, int tax_payable) {
        this.httpStatus = HttpStatus.OK;
        this.name = name;
        this.salary = salary;
        this.tax_payable = tax_payable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getTax_payable() {
        return tax_payable;
    }

    public void setTax_payable(int tax_payable) {
        this.tax_payable = tax_payable;
    }
}
