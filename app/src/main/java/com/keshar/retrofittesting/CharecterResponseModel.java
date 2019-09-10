package com.keshar.retrofittesting;

import java.util.List;

public class CharecterResponseModel {
    public final int count;
    public final String next;
    public final String previous;
    public final List<CharectersModel> results;

    public CharecterResponseModel(int count, String next, String previous, List<CharectersModel> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
}
