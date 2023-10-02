package com.app.containerstask.data;

import java.util.Comparator;

public enum SortType {
    NO_SORT((num1, num2) -> 0),
    ASCEND_SORT((num1, num2) -> num1.compareTo(num2)),
    DESCEND_SORT((num1, num2) -> num1.compareTo(num2) * -1);

    private final Comparator<Integer> comparator;

    SortType(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Integer> getComparator() {
        return comparator;
    }
}
