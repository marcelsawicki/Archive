import Vue from 'vue';
import { Component, Inject, Model, Prop, Watch } from 'vue-property-decorator';
import { Galeria } from './components/galeria/galeria';
import { Game } from './components/game/game';
import { Quiz } from './components/quiz/quiz';
        
    let vm = new Vue({
        el: '#app-main',
        components: 
        {
            'quiz': Quiz
        }
    });

