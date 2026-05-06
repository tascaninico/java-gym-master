package ru.yandex.practicum.gym;

import org.junit.Assert;
import org.junit.Test;

public class TrainingPerCoachTest {

    @Test
    public void testGetNumberOfCoaches(){

        Group group = new Group("Yoga", Age.ADULT, 60);
        Coach coach = new Coach("Ежиков", "Александр", "Петрович");
        TimeOfDay time = new TimeOfDay(10, 0);
        TrainingSession trainingSession = new TrainingSession(group, coach, DayOfWeek.MONDAY, time);

        Timetable timetable = new Timetable();
        timetable.addNewTrainingSession(trainingSession);

        Group group1 = new Group("BJJ", Age.CHILD, 120);
        Coach coach1 = new Coach("Антонов", "Владислав", "Антонович");
        TimeOfDay time1 = new TimeOfDay(16, 0);
        TrainingSession trainingSession2 = new TrainingSession(group1, coach1, DayOfWeek.TUESDAY, time1);

        timetable.addNewTrainingSession(trainingSession2);

        Assert.assertEquals(2, timetable.getCountByCoaches().size());
    }

    @Test
    public void testGetZeroTrainingTest(){

        Timetable timetable = new Timetable();

        Assert.assertEquals(0,timetable.getCountByCoaches().size());
    }

    @Test
    public void testSequienceOfCoaches(){

        Group group = new Group("Yoga", Age.ADULT, 60);
        Coach coach = new Coach("Ежиков", "Александр", "Петрович");
        TimeOfDay time = new TimeOfDay(10, 0);
        TrainingSession trainingSession = new TrainingSession(group, coach, DayOfWeek.MONDAY, time);

        Timetable timetable = new Timetable();
        timetable.addNewTrainingSession(trainingSession);

        Group group1 = new Group("BJJ", Age.CHILD, 120);
        Coach coach1 = new Coach("Антонов", "Владислав", "Антонович");
        TimeOfDay time1 = new TimeOfDay(16, 0);
        TrainingSession trainingSession2 = new TrainingSession(group1, coach1, DayOfWeek.TUESDAY, time1);

        timetable.addNewTrainingSession(trainingSession2);

        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        Coach coach3 = new Coach("Васильев", "Николай", "Сергеевич");
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

        Assert.assertEquals(3, timetable.getCountByCoaches().size());
        Assert.assertEquals(coach3, timetable.getCountByCoaches().get(0).getCoach());
        Assert.assertEquals(coach1, timetable.getCountByCoaches().get(1).getCoach());
        Assert.assertEquals(coach, timetable.getCountByCoaches().get(2).getCoach());
    }

}

