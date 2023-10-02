package com.app.containerstask.data;

public class ContainerData {
    private final int maxCapacity = 100;
    private int currentCapacity;

    public ContainerData(Integer value) {
        currentCapacity = value;
    }

    public void addElement(Integer element) {
        currentCapacity += element;
    }

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public boolean canHold(Integer element) {
        return currentCapacity + element <= maxCapacity;
    }

    public boolean isBetterFit(Integer element, int bestFitContainerResult) {
        return currentCapacity + element > bestFitContainerResult;
    }
}
