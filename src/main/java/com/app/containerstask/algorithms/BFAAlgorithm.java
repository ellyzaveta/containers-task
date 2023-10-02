package com.app.containerstask.algorithms;

import com.app.containerstask.allocationatrategy.BFAContainerAllocation;
import com.app.containerstask.data.SortType;

import java.util.List;

public class BFAAlgorithm extends GeneralAlgorithm {
    public BFAAlgorithm(List<Integer> row, SortType sortType) {
        super (new BFAContainerAllocation(), sortType, row);
    }
}
