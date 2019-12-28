import Vue from 'vue';
import { Component, Prop } from 'vue-property-decorator';

@Component({
    name: 'galeria',
    template: require('./galeria.html')
})

export class Galeria extends Vue {
    @Prop() url: string;
    source: string;
    nrPicture: number;
    constructor()
    {
        super();
        this.nrPicture = 1;
    }

    getSource(){
        
        let source = './components/galeria/content/' + this.nrPicture + '.jpg';
        
        return source;
    }
    doSomething(){
        console.log('say something...');
    }
    doNext()
    {
        console.log('do next...');
        this.nrPicture++;

    }

    doPrevious()
    {
        console.log('do previous...');
        this.nrPicture--;
    }
}