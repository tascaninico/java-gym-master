package ru.yandex.practicum.gym;

public enum Age {
    CHILD, ADULT;

    @Override
    public String toString(){
        return name().toUpperCase();
    }
}
