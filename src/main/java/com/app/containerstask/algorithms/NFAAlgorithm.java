package com.app.containerstask.algorithms;

import com.app.containerstask.allocationatrategy.NFAContainerAllocation;
import com.app.containerstask.data.SortType;

import java.util.List;

public class NFAAlgorithm extends GeneralAlgorithm {
    public NFAAlgorithm(List<Integer> row, SortType sortType) {
        super (new NFAContainerAllocation(), sortType, row);
    }
}
