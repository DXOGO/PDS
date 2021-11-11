//package pds_2021_111.lab01;

public class Solution {
    private String word;
    private int size;
    private Coordinates start;
    private Direction dir;

    Solution(String word, Coordinates start, Direction dir) {
        this.word = word;
        this.size = word.length();
        this.start = start;
        this.dir = dir;
    }

    public String getWord() { return word; }

    public int getSize() { return size; }

    public Coordinates getStart() { return start; }

    public Direction getDir() { return dir; }

    public String toString() {
        return String.format("%-20s%-5d%-8s%-10s", this.word, this.size, this.start.toString(), this.dir.toString());
    }                                        //     palavra    tamanho    posiçao da 1ª letra   direçao do resto da palavra

}
