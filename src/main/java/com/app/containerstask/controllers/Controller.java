package com.app.containerstask.controllers;

import com.app.containerstask.algorithms.BFAAlgorithm;
import com.app.containerstask.algorithms.FFAAlgorithm;
import com.app.containerstask.algorithms.NFAAlgorithm;
import com.app.containerstask.algorithms.WFAAlgorithm;
import com.app.containerstask.data.Result;
import com.app.containerstask.data.SortType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/dmt/lab2/")
public class Controller {

    private final List<Result> results = new ArrayList<>();

    private final List<Integer> row1 = List.of(39, 63, 35, 4, 73, 6, 64, 23, 51, 49, 51, 30, 39, 4, 65, 86, 2, 25, 79, 91);
    private final List<Integer> row2 = List.of(47, 7, 84, 31, 61, 19, 31, 53, 28, 27, 94, 19, 43, 81, 23, 68, 87, 39, 43, 38);
    private final List<Integer> row3 = List.of(88, 94, 20, 80, 98, 86, 18, 52, 63, 98, 95, 10, 5, 79, 42, 66, 98, 25, 72, 78);

    List<List<Integer>> rows = List.of(
            row1,
            row2,
            row3,
            Stream.of(row1, row2, row3)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList())
    );

    public Controller() {
        calculate();
    }

    private void calculate() {
        for (int i = 0; i < rows.size(); i++) {
            addToResult(i, SortType.NO_SORT);
            addToResult(i, SortType.ASCEND_SORT);
            addToResult(i, SortType.DESCEND_SORT);
        }
    }

    private void addToResult(int index, SortType sortType) {
        Result result = new NFAAlgorithm(copyList(rows.get(index)), sortType).algorithm();
        result.setRow(index);
        results.add(result);

        result = new FFAAlgorithm(copyList(rows.get(index)), sortType).algorithm();
        result.setRow(index);
        results.add(result);

        result = new WFAAlgorithm(copyList(rows.get(index)), sortType).algorithm();
        result.setRow(index);
        results.add(result);

        result = new BFAAlgorithm(copyList(rows.get(index)), sortType).algorithm();
        result.setRow(index);
        results.add(result);
    }

    private List<Integer> copyList(List<Integer> integers) {
        return new ArrayList<>(integers);
    }

    @GetMapping("/result")
    public List<Result> getNoSortResults() {
        return results;
    }

}

