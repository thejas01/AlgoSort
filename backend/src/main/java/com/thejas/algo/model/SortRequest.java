package com.thejas.algo.model;
import lombok.Data;

@Data
public class SortRequest {
    private int[] array;
    private String algorithm; // "bubble", "merge", etc.
}