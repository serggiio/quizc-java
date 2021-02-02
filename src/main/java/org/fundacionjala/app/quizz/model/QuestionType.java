package org.fundacionjala.app.quizz.model;

import org.fundacionjala.app.quizz.model.configuration.QuestionConfiguration;
import org.fundacionjala.app.quizz.model.configuration.TextConfiguration;
import org.fundacionjala.app.quizz.model.validator.ValidatorType;
import org.fundacionjala.app.quizz.model.configuration.DateConfiguration;
import org.fundacionjala.app.quizz.model.configuration.PickOneConfiguration;
import org.fundacionjala.app.quizz.model.configuration.NumberConfiguration;

public enum QuestionType {
    TEXT(1, "Text", new TextConfiguration()), DATE(2, "Date", new DateConfiguration()),
    PICK_ONE(3, "Pick One", new PickOneConfiguration()), NUMBER(4, "Number", new NumberConfiguration());

    private final int code;
    private final String displayName;
    private final QuestionConfiguration configuration;

    QuestionType(int code, String displayName, QuestionConfiguration configuration) {
        this.code = code;
        this.displayName = displayName;
        this.configuration = configuration;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return displayName;
    }

    public boolean hasAdditionalData() {
        return configuration.hasAdditionalData();
    }

    public ValidatorType[] getValidations() {
        return configuration.getSupportedValidations();
    }

    public QuestionConfiguration getConfiguration() {
        return configuration;
    }

    public static QuestionType getByCode(int option) {
        for (QuestionType type : QuestionType.values()) {
            if (type.getCode() == option) {
                return type;
            }
        }

        return null;
    }
}
