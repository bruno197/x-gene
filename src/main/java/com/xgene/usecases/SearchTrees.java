package com.xgene.usecases;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchTrees {
    private static final int[] DIRECTIONS_X = new int[] { 0, 0, 1, -1, 1, 1, -1, -1 };
    private static final int[] DIRECTIONS_Y = new int[] { 1, -1, 0, 0, 1, -1, 1, -1 };

    private int N = 6;
    private char[][] grid;

    public boolean contains(String[] dna, String word) {
        getGrid(dna);

        return findWord(word);
    }

    private boolean findWord(String word) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == word.charAt(0)) {
                    if (checkDirections(i, j, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public char[][] getGrid(String[] dna) {
        grid = new char[6][6];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = dna[i].charAt(j);
            }
        }
        return grid;
    }

    private boolean checkDirections(int initX, int initY, String word) {
        for (int dirIndex = 0; dirIndex < DIRECTIONS_X.length; ++dirIndex) {
            boolean wordMatches = true;
            for (int charIndex = 0; charIndex < word.length() && wordMatches; ++charIndex) {
                int x = initX + DIRECTIONS_X[dirIndex] * charIndex;
                int y = initY + DIRECTIONS_Y[dirIndex] * charIndex;
                if (x < 0 || y < 0 || x >= N || y >= N || grid[x][y] != word.charAt(charIndex)) {
                    wordMatches = false;
                }
            }

            if (wordMatches) {
                return true;
            }
        }

        return false;
    }
}
