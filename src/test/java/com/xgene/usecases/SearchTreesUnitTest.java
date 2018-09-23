package com.xgene.usecases;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTreesUnitTest {
    private static final String[] MUTANT_DNA_SEQUENCES = {"AAAA", "CCCC", "GGGG", "TTTT"};

    @InjectMocks
    private SearchTrees searchTrees;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findWithSuccess() {
        String[] dna = {"ATGCGA","CGGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutant = false;
        for(int i = 0 ; i < MUTANT_DNA_SEQUENCES.length ; i++) {
            if(this.searchTrees.contains(dna, MUTANT_DNA_SEQUENCES[i])) {
                isMutant = true;
                break;
            }
        }

        assertTrue(isMutant);
    }

    @Test
    public void dontFind() {
        String[] dna = {"ATGCGA","CGGTCC","TTATGT","AGAAGG","CACCTA","TCACTG"};
        boolean isMutant = false;
        for(int i = 0 ; i < MUTANT_DNA_SEQUENCES.length ; i++) {
            if(this.searchTrees.contains(dna, MUTANT_DNA_SEQUENCES[i])) {
                isMutant = true;
                break;
            }
        }

        assertFalse(isMutant);
    }

    @Test
    public void findWithDiagonal() {
        String[] dna = {"ATGCGA","CAGTCC","TTATGT","AGAAGG","CGCCTA","TCACTG"};
        boolean isMutant = false;
        for(int i = 0 ; i < MUTANT_DNA_SEQUENCES.length ; i++) {
            if(this.searchTrees.contains(dna, MUTANT_DNA_SEQUENCES[i])) {
                isMutant = true;
                break;
            }
        }

        assertTrue(isMutant);
    }

}