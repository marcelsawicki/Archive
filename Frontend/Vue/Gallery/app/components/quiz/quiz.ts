import Vue from 'vue';
import { Component, Prop } from 'vue-property-decorator';
import { QuizMock } from './quiz-mock'

let quiz = QuizMock;

let userResponses = {};

@Component({
    name: 'quiz',
    template: require('./quiz.html'),

    data: function () {
                         return {
                                 quiz: quiz,
                                 userResponses: Array(quiz.questions.length).fill(false),
                                }
                        }
})

export class Quiz extends Vue {
    questionIndex: number = 0;
    userResponses: {
        filter;
    };
    Next(){
        this.questionIndex++;
    }
    Prev(){
        this.questionIndex--;
    }
    Score(){
        return this.userResponses.filter(function(val) { return val==true }).length;
    }
}