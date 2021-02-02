package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorIT {

    @Test
    public void testDateValidator() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/12/2021", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testMaxLengthValidator() {
        List<String> errors = new ArrayList<>();
        Validator maxLengthValidator = ValidatorType.MAX_LENGTH.getValidator();

        maxLengthValidator.validate("aaaaaaa", "10", errors);

        // Assert.assertEquals(DateValidator.class, maxLengthValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    /*
     * Test on max validator 15 less than 18
     */
    @Test
    public void testMaxValidator() {
        List<String> errors = new ArrayList<>();
        Validator maxValidator = ValidatorType.MAX.getValidator();

        maxValidator.validate("15", "18", errors);

        // Assert.assertEquals(DateValidator.class, maxLengthValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    /*
     * Test on min length validator condition value 5
     */
    @Test
    public void testMinLengthValidator() {
        List<String> errors = new ArrayList<>();
        Validator minLengthValidator = ValidatorType.MIN_LENGTH.getValidator();

        minLengthValidator.validate("test minLength working!", "5", errors);

        // Assert.assertEquals(DateValidator.class, maxLengthValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    /*
     * Test on max validator 18 greater than 15
     */
    @Test
    public void testMinValidator() {
        List<String> errors = new ArrayList<>();
        Validator minValidator = ValidatorType.MIN.getValidator();

        minValidator.validate("18", "15", errors);

        // Assert.assertEquals(DateValidator.class, maxLengthValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    /*
     * Test on max required validator value = 'field with some text'
     */
    @Test
    public void testRequiredValidator() {
        List<String> errors = new ArrayList<>();
        Validator minValidator = ValidatorType.REQUIRED.getValidator();

        minValidator.validate("field with some text", null, errors);

        // Assert.assertEquals(DateValidator.class, maxLengthValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

}
