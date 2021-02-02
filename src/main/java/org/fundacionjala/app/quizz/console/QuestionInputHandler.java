package org.fundacionjala.app.quizz.console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.validator.MinValidator;
import org.fundacionjala.app.quizz.model.validator.Validator;
import org.fundacionjala.app.quizz.console.util.InputReader;

import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class QuestionInputHandler {
    List<String> errors = new ArrayList<>();

    public Set<String> askQuestionValue(Question question) {
        System.out.println("Question: " + question.getTitle());

        Set<String> answers = getAnswer(question);
        setValidator(question.getValidations(), answers);

        while (!errors.isEmpty()) {
            answers = getAnswer(question);
            errors = new ArrayList<>();
            setValidator(question.getValidations(), answers);
        }

        return answers;
    }

    private void setValidator(List<ValidatorType> list, Set<String> answers) {

        for (var itemValidation : list) {
            for (var itemAnswer : answers) {
                if (itemValidation.getCode() == 1 || itemValidation.getCode() == 2) {
                    itemValidation.getValidator().validate(itemAnswer, null, errors);
                } else if (itemValidation.getCode() == 3 || itemValidation.getCode() == 4) {
                    itemValidation.getValidator().validate(itemAnswer, "5", errors);
                } else if (itemValidation.getCode() == 5) {
                    itemValidation.getValidator().validate(itemAnswer, "50", errors);
                } else if (itemValidation.getCode() == 6) {
                    itemValidation.getValidator().validate(itemAnswer, "10", errors);
                }

                if (!errors.isEmpty()) {
                    System.out.println("Your answer contains the following errors: ");
                    for (var itemError : errors) {
                        System.out.println(itemError);
                    }
                } else {
                    errors = new ArrayList<>();
                }
            }

        }

    }

    private Set<String> getAnswer(Question question) {
        Set<String> answers = new HashSet<>();
        if (question.getType().getConfiguration().hasAdditionalData()) {
            answers.add(collectAnswerFromOptions(question));
        } else {
            System.out.println(question.getType().getName() + " value:");
            String value = InputReader.readLine();

            answers.add(value);
        }

        return answers;
    }

    private String collectAnswerFromOptions(Question question) {
        String answer = null;

        while (true) {
            showOptions(question);
            char option = InputReader.readOption();
            if (option == '0') {
                break;
            }
        }

        return answer;
    }

    private void showOptions(Question question) {
        System.out.println("Select an option: ");
        for (int index = 0; index < question.getAdditionalData().size(); index++) {
            System.out.printf("%d. %s" + System.lineSeparator(), index + 1, question.getAdditionalData().get(index));
        }
        System.out.println("0. To Finish");
    }
}
