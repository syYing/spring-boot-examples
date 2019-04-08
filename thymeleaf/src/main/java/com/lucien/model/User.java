
package com.lucien.model;

public class User {

    private String name;
    private int age;
    private String pass;

    public User(String name, int age, String pass) {
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "name = " + this.name + ", age = " + this.age + ", pass = " + this.pass;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return String return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}
