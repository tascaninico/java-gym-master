package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private final HashMap<DayOfWeek, TreeMap<TimeOfDay, ArrayList<TrainingSession>>> timetable = new HashMap<>();

    public void addNewTrainingSession(TrainingSession trainingSession) {

        DayOfWeek dayOfWeek = trainingSession.getDayOfWeek();
        TimeOfDay timeOfDay = trainingSession.getTimeOfDay();

        if (!timetable.containsKey(dayOfWeek)){
            timetable.put(dayOfWeek, new TreeMap<>());
        }

        if (!timetable.get(dayOfWeek).containsKey(timeOfDay)){
            timetable.get(dayOfWeek).put(timeOfDay, new ArrayList<>());
        }

        timetable.get(dayOfWeek).get(timeOfDay).add(trainingSession);

    }

    public Map<TimeOfDay, ArrayList<TrainingSession>> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        if (timetable.containsKey(dayOfWeek)) {
            return timetable.get(dayOfWeek);
        }
        return Map.of();
    }

    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {

        if (timetable.containsKey(dayOfWeek) && timetable.get(dayOfWeek).containsKey(timeOfDay)){
            return timetable.get(dayOfWeek).get(timeOfDay);
        }
        return List.of();
    }

    public List<Counter> getCountByCoaches(){

        HashMap<Coach, Integer> numOfTrainingsPerCoach = new HashMap<>();

        Set<DayOfWeek> dayOfWeekSet = timetable.keySet();

        for (DayOfWeek dayOfWeek: dayOfWeekSet){
            Set<TimeOfDay> timeOfDaySet = timetable.get(dayOfWeek).keySet();

            for (TimeOfDay timeOfDay : timeOfDaySet){
                for (TrainingSession trainingSession :timetable.get(dayOfWeek).get(timeOfDay)){

                    if (!(numOfTrainingsPerCoach.containsKey(trainingSession.getCoach()))){
                        numOfTrainingsPerCoach.put(trainingSession.getCoach(), 1);
                    } else {
                        numOfTrainingsPerCoach.put(trainingSession.getCoach(),
                                numOfTrainingsPerCoach.get(trainingSession.getCoach())+1);
                    }
                }
            }
        }

        List<Counter> counters = new ArrayList<>();

        for (Map.Entry<Coach, Integer> pair : numOfTrainingsPerCoach.entrySet()){
            counters.add(new Counter(pair.getKey(), pair.getValue()));
        }

        counters.sort(Collections.reverseOrder());

        return counters;
    }

}
