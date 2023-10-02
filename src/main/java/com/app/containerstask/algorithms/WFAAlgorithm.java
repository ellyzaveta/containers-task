package com.app.containerstask.algorithms;

import com.app.containerstask.allocationatrategy.WFAContainerAllocation;
import com.app.containerstask.data.SortType;

import java.util.List;

public class WFAAlgorithm extends GeneralAlgorithm {
    public WFAAlgorithm(List<Integer> row, SortType sortType) {
        super (new WFAContainerAllocation(), sortType, row);
    }
}
