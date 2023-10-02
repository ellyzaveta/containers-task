package com.app.containerstask.algorithms;

import com.app.containerstask.allocationatrategy.ContainerAllocation;
import com.app.containerstask.data.ContainerData;
import com.app.containerstask.data.Result;
import com.app.containerstask.data.SortType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneralAlgorithm {

    private final ContainerAllocation containerAllocation;
    private final SortType sortType;
    private final List<Integer> row;

    public GeneralAlgorithm(ContainerAllocation containerAllocation, SortType sortType, List<Integer> row) {
        this.containerAllocation = containerAllocation;
        this.sortType = sortType;
        this.row = row;
    }

    public Result algorithm() {

        row.sort(sortType.getComparator());

        AtomicInteger comparesNum = new AtomicInteger(1);
        List<ContainerData> containers = new ArrayList<>();
        AtomicInteger currentIndex = new AtomicInteger();

        row.forEach(element -> {

            if (containers.isEmpty()) {
                containers.add(new ContainerData(element));
                return;
            }

            ContainerData currentContainer = containers.get(currentIndex.get());

            if (currentContainer.canHold(element)) {
                ContainerData containerData = containers.get(currentIndex.get());
                containerData.addElement(element);
            } else {
                containerAllocation.allocate(currentIndex, containers, comparesNum, element);
            }

            comparesNum.getAndIncrement();
        });

        String alg = containerAllocation.getClass().getSimpleName().substring(0, 3);
        return new Result(alg, sortType.toString(), containers.size(), getGeneralComparesNum(comparesNum));

    }

    private int getGeneralComparesNum(AtomicInteger comparesNum) {
        int generalComparesNum = comparesNum.get();
        generalComparesNum += sortType != SortType.NO_SORT ? calculateComplexity(row) : 0;
        return generalComparesNum;
    }

    private int calculateComplexity(List<Integer> row) {
        return (int) Math.round(Math.log(row.size()) * row.size());
    }
}
