package ru.yandex.practicum.gym;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TimetableTest {

    @Test
    public void testGetTrainingSessionsForDaySingleSession() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        int numberOfTrainingsOnMonday = 0;
        Map<TimeOfDay, ArrayList<TrainingSession>> trainingsForMonday = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        Set<TimeOfDay> times = trainingsForMonday.keySet();

        for (TimeOfDay timeOfDay : times){
            numberOfTrainingsOnMonday += trainingsForMonday.get(timeOfDay).size();
        }

        Assert.assertEquals(1, numberOfTrainingsOnMonday);

        int numberOfTrainingsOnTuesday = 0;

        Map<TimeOfDay, ArrayList<TrainingSession>> trainingsForTuesday = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
        Set<TimeOfDay> times1 = trainingsForTuesday.keySet();

        for (TimeOfDay timeOfDay : times1){
            numberOfTrainingsOnTuesday += trainingsForTuesday.get(timeOfDay).size();
        }

        Assert.assertEquals(0, numberOfTrainingsOnTuesday);
    }

    @Test
    public void testGetTrainingSessionsForDayMultipleSessions() {
        Timetable timetable = new Timetable();

        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");

        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        TrainingSession thursdayAdultTrainingSession = new TrainingSession(groupAdult, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(20, 0));

        timetable.addNewTrainingSession(thursdayAdultTrainingSession);

        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));
        TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(13, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.SATURDAY, new TimeOfDay(10, 0));

        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);

        int numberOfTrainingsOnMonday = 0;
        Map<TimeOfDay, ArrayList<TrainingSession>> trainingsForMonday = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        Set<TimeOfDay> times = trainingsForMonday.keySet();

        for (TimeOfDay timeOfDay : times){
            numberOfTrainingsOnMonday += trainingsForMonday.get(timeOfDay).size();
        }

        Assert.assertEquals(1, numberOfTrainingsOnMonday);


        List<TrainingSession> allTranningSessionsOnThursday = new ArrayList<>();

        for (TimeOfDay timeOfDay: timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY).keySet()){
            allTranningSessionsOnThursday.addAll(timetable.getTrainingSessionsForDayAndTime(DayOfWeek.THURSDAY, timeOfDay));
        }

        Assert.assertEquals(2, allTranningSessionsOnThursday.size());
        Assert.assertEquals(new TimeOfDay(13, 0), allTranningSessionsOnThursday.get(0).getTimeOfDay());
        Assert.assertEquals(new TimeOfDay(20, 0), allTranningSessionsOnThursday.get(1).getTimeOfDay());


        int numberOfTrainningsOnTuesday = 0;
        Map<TimeOfDay, ArrayList<TrainingSession>> trainingsForTuesday = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
        Set<TimeOfDay> times1 = trainingsForTuesday.keySet();

        for (TimeOfDay timeOfDay : times1){
            numberOfTrainningsOnTuesday += trainingsForMonday.get(timeOfDay).size();
        }

        Assert.assertEquals(0, numberOfTrainningsOnTuesday);
    }

    @Test
    public void testGetTrainingSessionsForDayAndTime() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        List<TrainingSession> numberOfTrainningsOnMonday =
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(13,0));
        Assert.assertEquals(1, numberOfTrainningsOnMonday.size());

        List<TrainingSession> numberOfTrainningsOnTuesday =
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(14,0));
        Assert.assertEquals(0, numberOfTrainningsOnTuesday.size());
    }

}
