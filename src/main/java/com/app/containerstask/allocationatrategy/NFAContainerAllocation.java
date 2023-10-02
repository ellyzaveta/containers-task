package com.app.containerstask.allocationatrategy;

import com.app.containerstask.data.ContainerData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NFAContainerAllocation implements ContainerAllocation {

    @Override
    public void allocate(AtomicInteger currentIndex, List<ContainerData> containers, AtomicInteger comparesNum, Integer element) {
        currentIndex.getAndIncrement();
        containers.add(currentIndex.get(), new ContainerData(element));
    }
}

