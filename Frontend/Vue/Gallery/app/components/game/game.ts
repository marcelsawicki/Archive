import Vue from 'vue';
import { Prop, Component } from 'vue-property-decorator';

@Component({
    name: 'game',
    template: require('./game.html'),
})

export class Game extends Vue {
    message: string;
    todos = [
      { text: 'Learn JavaScript' },
      { text: 'Learn Vue' },
      { text: 'Build something awesome' }
    ]

}