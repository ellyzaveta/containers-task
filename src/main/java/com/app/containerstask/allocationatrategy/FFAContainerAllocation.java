package com.app.containerstask.allocationatrategy;

import com.app.containerstask.data.ContainerData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FFAContainerAllocation implements ContainerAllocation {

    @Override
    public void allocate(AtomicInteger currentIndex, List<ContainerData> containers, AtomicInteger comparesNum, Integer element) {
        for (int i = 0; i < containers.size(); i++) {
            ContainerData container = containers.get(i);
            comparesNum.getAndIncrement();
            if (container.canHold(element)) {
                container.addElement(element);
                currentIndex.set(containers.size() - 1);
                break;
            }
            if (isAllAvailableContainersChecked(i, containers.size())) {
                currentIndex.getAndIncrement();
                containers.add(currentIndex.get(), new ContainerData(element));
                break;
            }
        }
    }

    private boolean isAllAvailableContainersChecked(int i, int containersNum) {
        return i == containersNum - 1;
    }
}

