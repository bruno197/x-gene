package com.xgene.http.constraintvalidators.impl;

import com.xgene.http.constraintvalidators.DnaChar;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class DnaCharValidator implements ConstraintValidator<DnaChar, String[]> {

    @Override public void initialize(final DnaChar constraintAnnotation) {

    }

    @Override public boolean isValid(final String[] strings, final ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if (StringUtils.isEmpty(strings)) {
            return isValid;
        }
        Pattern pattern = Pattern.compile("^[ATCGatcg]{6}$");
        for(int i = 0 ; i < strings.length ; i++) {
            if(!pattern.matcher(strings[i]).matches()) {
                return false;
            }
        }
        return true;
    }
}
