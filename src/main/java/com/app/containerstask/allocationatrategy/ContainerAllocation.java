package com.app.containerstask.allocationatrategy;

import com.app.containerstask.data.ContainerData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface ContainerAllocation {
    void allocate(AtomicInteger currentIndex, List<ContainerData> containers, AtomicInteger comparesNum, Integer element);
}
