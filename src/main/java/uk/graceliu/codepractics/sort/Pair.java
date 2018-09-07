package uk.graceliu.codepractics.sort;

import java.util.List;

public class Pair {
    public List<Pair> children;
    int start;
    int end;

    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
