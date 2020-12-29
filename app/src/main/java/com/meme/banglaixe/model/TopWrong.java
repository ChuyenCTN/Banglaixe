package com.meme.banglaixe.model;

import java.util.List;

public class TopWrong {
    private String question;
    private String imageLink;
    private List<AnswerWrong> Answers;

    public TopWrong(String question, String imageLink, List<AnswerWrong> answers) {
        this.question = question;
        this.imageLink = imageLink;
        Answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerWrong> getAnswers() {
        return Answers;
    }

    public void setAnswers(List<AnswerWrong> answers) {
        Answers = answers;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public static class AnswerWrong {
        private String answer;
        private boolean isRight;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public boolean isRight() {
            return isRight;
        }

        public void setRight(boolean right) {
            isRight = right;
        }

        public AnswerWrong(String answer, boolean isRight) {
            this.answer = answer;
            this.isRight = isRight;
        }
    }


}
