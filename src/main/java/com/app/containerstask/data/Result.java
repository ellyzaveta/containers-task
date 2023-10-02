package com.app.containerstask.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    Integer row;
    String sortType;
    String alg;
    int containerNum;
    int complexity;

    public Result(String alg, String sortType, int containerNum,  int complexity) {
        this.alg = alg;
        this.sortType = sortType;
        this.complexity = complexity;
        this.containerNum = containerNum;
    }
}

