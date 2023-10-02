package com.app.containerstask.allocationatrategy;

import com.app.containerstask.data.ContainerData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BFAContainerAllocation implements ContainerAllocation {

    @Override
    public void allocate(AtomicInteger currentIndex, List<ContainerData> containers, AtomicInteger comparesNum, Integer element) {
        List<Integer> bestFitContainer = findBestFitContainer(containers, comparesNum, element);

        int bestFitContainerIndex = bestFitContainer.get(0);
        int bestFitContainerValue = bestFitContainer.get(1);

        if (bestFitContainerValue != Integer.MIN_VALUE) {
            ContainerData container = containers.get(bestFitContainerIndex);
            container.addElement(element);
            currentIndex.set(containers.size() - 1);
        } else {
            currentIndex.getAndIncrement();
            containers.add(currentIndex.get(), new ContainerData(element));
        }
        comparesNum.getAndIncrement();
    }

    private List<Integer> findBestFitContainer(List<ContainerData> containers, AtomicInteger compares, Integer element) {
        int bestFitContainerResult = Integer.MIN_VALUE;
        int bestFitContainerIndex = -1;

        for (int i = 0; i < containers.size(); i++) {
            compares.set(compares.get() + 2);
            ContainerData container = containers.get(i);
            if (container.canHold(element) && container.isBetterFit(element, bestFitContainerResult)) {
                bestFitContainerResult = container.getCurrentCapacity() + element;
                bestFitContainerIndex = i;
            }
        }

        return List.of(bestFitContainerIndex, bestFitContainerResult);
    }
}

