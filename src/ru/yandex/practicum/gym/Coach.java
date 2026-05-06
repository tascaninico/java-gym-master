package ru.yandex.practicum.gym;

import java.util.Objects;

public class Coach {


    private String surname;

    private String name;

    private String middleName;

    public Coach(String surname, String name, String middleName) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;
        Coach coach = (Coach) o;
        return Objects.equals(this.surname, coach.getSurname()) &&
                Objects.equals(this.name, coach.getName()) &&
                Objects.equals(this.middleName, coach.getMiddleName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(surname, name, middleName);
    }


    @Override
    public String toString(){
        return "Coach : " + surname + " " + name + " " + middleName;
    }

}