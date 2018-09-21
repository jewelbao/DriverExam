package com.jewel.model;

import java.util.List;

import lombok.Data;

@Data
public class ListData<T> {

    private int curPage;
    private List<T> list;
    private int total;
}
