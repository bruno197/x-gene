package com.xgene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        HashMap<Long, String> map1 = new HashMap<>();
        map1.put(1L, "a");
        map1.put(2L, "t");
        map1.put(3L, "g");
        map1.put(4L, "c");
        map1.put(5L, "g");
        map1.put(6L, "a");

        HashMap<Long, String> map2 = new HashMap<>();
        map2.put(1L, "c");
        map2.put(2L, "a");
        map2.put(3L, "g");
        map2.put(4L, "t");
        map2.put(5L, "g");
        map2.put(6L, "c");

        HashMap<Long, String> map3 = new HashMap<>();
        map3.put(1L, "t");
        map3.put(2L, "t");
        map3.put(3L, "a");
        map3.put(4L, "t");
        map3.put(5L, "g");
        map3.put(6L, "t");

        HashMap<Long, String> map4 = new HashMap<>();
        map4.put(1L, "a");
        map4.put(2L, "g");
        map4.put(3L, "a");
        map4.put(4L, "a");
        map4.put(5L, "g");
        map4.put(6L, "g");

        HashMap<Long, String> map5 = new HashMap<>();
        map5.put(1L, "c");
        map5.put(2L, "c");
        map5.put(3L, "c");
        map5.put(4L, "c");
        map5.put(5L, "g");
        map5.put(6L, "t");

        int count = Collections.frequency(map5.values(), "c");
        System.out.println("count "+count);

        map1.forEach((map1Id, map1Dna) -> {
            System.out.println(map1Id + " => " + map1Dna);
            map2.forEach((map2Id, map2Dna) -> {
                System.out.println(map2Id + " => " + map2Dna);
            });
        });
    }

//    private static final String[] MUTANT_DNA_SEQUENCES = {"AAAA", "CCCC", "GGGG", "TTTT"};
//    public int N;
//    private static int rowDirs[] = {-1, -1, -1, 0, 0, 1, 1, 1};
//    static int colDirs[] = {-1, 0, 1, -1, 1, -1, 0, 1};
//    private int count = 0;
//
//
//    boolean isSafe(int i, int j) {
//
//        if (i >= 0 && i <= (N - 1) && j >= 0 && j <= N - 1) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public boolean analyzeDNA(String[] adn) {
//        N = adn.length;
//
//        for (String mutantDnaSeq : MUTANT_DNA_SEQUENCES) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    findAndCountDnaSequence(adn, i, j, mutantDnaSeq);
//
//                    if (count >= 2) {
//                        return Boolean.TRUE;
//                    }
//                }
//            }
//        }
//
//        return Boolean.FALSE;
//    }
//
//    private void findAndCountDnaSequence(String[] adn, int row, int col, String word) {
//
//        if (adn[row].charAt(col) != word.charAt(0)) {
//            return;
//        }
//
//        int len = word.length();
//
//        for (int dir = 0; dir < 8; ++dir) {
//            int rowDir = row + rowDirs[dir];
//            int colDir = col + colDirs[dir];
//            int i;
//
//            for (i = 1; i <= len - 1; i++) {
//
//                if (!isSafe(rowDir, colDir)) {
//                    break;
//
//                }
//
//                if (!(adn[rowDir].charAt(colDir) == word.charAt(i))) {
//                    break;
//                }
//
//                rowDir = rowDir + rowDirs[dir];
//                colDir = colDir + colDirs[dir];
//            }
//
//            if (i == len) {
//                count++;
//
//                if (count >= 2) {
//                    return;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] adn = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//
//        Main ma = new Main();
//
//        boolean mutant = ma.analyzeDNA(adn);
//        System.out.println("Mutante: " + mutant);
//    }
}
