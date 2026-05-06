package ru.yandex.practicum.gym;

public class Counter implements Comparable<Counter> {

    private Coach coach;

    private int numberOfTraining;

    public Counter(Coach coach, int numberOfTraining) {
        this.coach = coach;
        this.numberOfTraining = numberOfTraining;
    }

    public int getNumberOfTraining() {
        return numberOfTraining;
    }

    public Coach getCoach() {
        return coach;
    }

    @Override
    public String toString() {
        return coach.toString() + " = " + numberOfTraining;
    }


    @Override
    public int compareTo(Counter other) {
        return Integer.compare(numberOfTraining, other.getNumberOfTraining());
    }
}