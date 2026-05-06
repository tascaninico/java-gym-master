package ru.yandex.practicum.gym;

public class Main {
    public static void main(String[] args) {

        Group group = new Group("Yoga", Age.ADULT, 60);
        Coach coach = new Coach("Ежиков", "Александр", "Петрович");
        TimeOfDay time = new TimeOfDay(10, 0);
        TrainingSession trainingSession1 = new TrainingSession(group, coach, DayOfWeek.MONDAY, time);
        Timetable timetable = new Timetable();
        timetable.addNewTrainingSession(trainingSession1);

        Group group2 = new Group("Yoga", Age.CHILD, 60);
        Coach coach2 = new Coach("Антонов", "Владислав", "Антонович");
        TimeOfDay time2 = new TimeOfDay(13, 0);
        TrainingSession trainingSession3 = new TrainingSession(group2, coach2, DayOfWeek.THURSDAY, time2);
        timetable.addNewTrainingSession(trainingSession3);

        Group group1 = new Group("BJJ", Age.CHILD, 120);
        Coach coach1 = new Coach("Антонов", "Владислав", "Антонович");
        TimeOfDay time1 = new TimeOfDay(16, 0);
        TrainingSession trainingSession2 = new TrainingSession(group1, coach1, DayOfWeek.TUESDAY, time1);
        timetable.addNewTrainingSession(trainingSession2);

        Coach coach3 = new Coach("Васильев", "Николай", "Сергеевич");

        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        TrainingSession thursdayAdultTrainingSession = new TrainingSession(groupAdult, coach3,
                DayOfWeek.THURSDAY, new TimeOfDay(20, 0));

        timetable.addNewTrainingSession(thursdayAdultTrainingSession);

        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach3,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));
        TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach3,
                DayOfWeek.THURSDAY, new TimeOfDay(13, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach3,
                DayOfWeek.SATURDAY, new TimeOfDay(10, 0));

        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);

        System.out.println(timetable.getCountByCoaches());

    }
}