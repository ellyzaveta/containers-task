package com.app.containerstask.algorithms;

import com.app.containerstask.allocationatrategy.FFAContainerAllocation;
import com.app.containerstask.data.SortType;

import java.util.List;

public class FFAAlgorithm extends GeneralAlgorithm {
    public FFAAlgorithm(List<Integer> row, SortType sortType) {
        super (new FFAContainerAllocation(), sortType, row);
    }
}
