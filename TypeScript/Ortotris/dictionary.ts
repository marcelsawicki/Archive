export class Dictionary {
    element: HTMLElement;
    span: HTMLElement;
    timerToken: number;
    list: string[] = ['miecz', 'zbroja', 'wlocznia']; // dopisalem
    constructor(element: HTMLElement) {
        this.element = element;
        let kostkaDoGry = Math.floor(Math.random() * 3);
        let numerNaStrone: string = this.list[kostkaDoGry];
        this.element.innerHTML += "Wybieram z tablicy: " + numerNaStrone + ". ";
        this.element.innerHTML += "Losuje jakas wartosc od 0 do 100: " + Math.floor(Math.random() * 100);
        this.span = document.createElement('span');
        this.element.appendChild(this.span);
        // this.span.innerText = new Date().toUTCString();
    }
    start() {
        this.timerToken = setInterval(() => this.span.innerHTML = new Date().toUTCString(), 500);
    }

    stop() {
        clearTimeout(this.timerToken);
    }
}

class Slowo {
    pytanie: string;
    odpowiedz: string;
    wybor1: string;
    wybor2: string;
}

let tablicaSlow: Array<Slowo> = [
    { pytanie: 'wie_a', odpowiedz: 'wieża', wybor1: 'ż', wybor2: 'rz'},
    { pytanie: 'spi_owy', odpowiedz: 'spiżowy', wybor1: 'ż', wybor2: 'rz'},
    { pytanie: 'ro_a', odpowiedz: 'róża', wybor1: 'ż', wybor2: 'rz'},
    { pytanie: '_ywica', odpowiedz: 'żywiaca', wybor1: 'ż', wybor2: 'rz'},
    ];