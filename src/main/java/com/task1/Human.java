package com.task1;

public class Human {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Human(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = "empty";
    }

    public Human(String lastName, String firstName, String middleName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFullName() {
        if(this.middleName.equals("empty")) {
            return (this.firstName + " " + this.lastName);
        }
        return (this.firstName + " " + this.middleName + " " + this.lastName);
    }

    public String getShortName() {
        if(this.middleName.equals("empty")) {
            return (this.lastName + " " + this.firstName.substring(0, 1).toUpperCase() + ".");
        }
        return (
                this.lastName + " " + this.firstName.substring(0, 1).toUpperCase() + "." +
                        this.middleName.substring(0, 1).toUpperCase() + "."
        );
    }

    public static void main(String[] args) {
        Human human1 = new Human("Иван", "Василиевич", "Пупкин");
        System.out.println(human1.getFullName());
        System.out.println(human1.getShortName());

        Human human2 = new Human("Иван", "Пупкин");
        System.out.println(human2.getFullName());
        System.out.println(human2.getShortName());
    }
}
