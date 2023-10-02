package com.app.containerstask.allocationatrategy;

import com.app.containerstask.data.ContainerData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WFAContainerAllocation implements ContainerAllocation {

    @Override
    public void allocate(AtomicInteger currentIndex, List<ContainerData> containers, AtomicInteger comparesNum, Integer element) {
        int minFitContainerIndex = findMinFitContainer(containers, comparesNum);

        ContainerData container = containers.get(minFitContainerIndex);

        if (container.canHold(element)) {
            container.addElement(element);
            currentIndex.set(containers.size() - 1);
        } else {
            currentIndex.getAndIncrement();
            containers.add(currentIndex.get(), new ContainerData(element));
        }

        comparesNum.getAndIncrement();
    }

    private int findMinFitContainer(List<ContainerData> containers, AtomicInteger compares) {
        int minFitContainerSize = Integer.MAX_VALUE;
        int minFitContainerIndex = -1;

        for (int i = 0; i < containers.size(); i++) {
            ContainerData container = containers.get(i);
            int sum = container.getCurrentCapacity();

            if (minFitContainerSize > sum) {
                minFitContainerSize = sum;
                minFitContainerIndex = i;
            }
            compares.getAndIncrement();
        }

        return minFitContainerIndex;
    }
}

