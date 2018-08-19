
/*
 * Copyright (c) 2011-2025 PiChen
 */

package org.summerframework.beans;

public class Employee extends TestBean {

    private String co;

    /**
     * Constructor for Employee.
     */
    public Employee() {
        super();
    }

    public String getCompany() {
        return co;
    }

    public void setCompany(String co) {
        this.co = co;
    }

}
