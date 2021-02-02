package org.fundacionjala.app.quizz.model.configuration;

import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class NumberConfiguration extends QuestionConfiguration {
    public NumberConfiguration() {
        super(false, ValidatorType.REQUIRED, ValidatorType.MIN, ValidatorType.MAX);
    }
}
