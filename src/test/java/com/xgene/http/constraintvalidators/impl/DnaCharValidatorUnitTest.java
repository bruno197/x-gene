package com.xgene.http.constraintvalidators.impl;

import com.xgene.http.constraintvalidators.DnaChar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DnaCharValidatorUnitTest {
    private DnaCharValidator dnaCharValidator;

    @Before
    public void setUp() {
        dnaCharValidator = new DnaCharValidator();
    }

    @Test
    public void shouldReturnTrueOnValidate() {
        @DnaChar
        String[] dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assert.assertTrue(dnaCharValidator.isValid(dna, null));
    }

    @Test
    public void shouldReturnFalseOnValidate() {
        @DnaChar
        String[] dna = new String[]{"ATXGHGA","CAZTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assert.assertFalse(dnaCharValidator.isValid(dna, null));
    }

    @Test
    public void shouldReturnTrueOnNullValue() {
        Assert.assertFalse(dnaCharValidator.isValid(null, null));
    }

}