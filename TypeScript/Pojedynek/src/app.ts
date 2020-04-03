class Greeter {
    element: HTMLElement;
    span: HTMLElement;
    timerToken: number;

    constructor(element: HTMLElement) {
        this.element = element;
        this.element.innerHTML += "The time is: ";
        this.span = document.createElement('span');
        this.element.appendChild(this.span);
        this.span.innerText = new Date().toUTCString();
        this.timerToken = 0;
    }

    start() {
        this.timerToken = setInterval(() => this.span.innerHTML = new Date().toUTCString(), 500);
    }

    stop() {
        clearTimeout(this.timerToken);
    }

}

class Hafn {
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
        this.timerToken = 0;
        // this.span.innerText = new Date().toUTCString();
    }
    start() {
        this.timerToken = setInterval(() => this.span.innerHTML = new Date().toUTCString(), 500);
    }

    stop() {
        clearTimeout(this.timerToken);
    }
}

let r_zdarzenia: string[] = ['wrog', 'nieznajomy', 'przedmiot', 'nic'];
let r_nieznajomego: string[] = ['zlodziej', 'dobry_d', 'zly_d', 'czarodziej'];
let r_przedmiotu: string[] = ['miecz', 'zbroja', 'eliksir', 'mieso', 'zloto', 'trucizna'];

class OpisSwiata {
    opis: string = '';
    prawdo: number = 0;
    rodzaj: number[] = [1];
    sila: number = 0;
}

let swiat: Array<OpisSwiata> = [
    { opis: 'nic', prawdo: 40, rodzaj: [1], sila: 7 },
    { opis: 'oblesny gnom', prawdo: 10, rodzaj: [1], sila: 2 },
    { opis: 'wielki smok', prawdo: 5, rodzaj: [1], sila: 7 },
    { opis: 'straszny troll', prawdo: 10, rodzaj: [1], sila: 3 },
    { opis: 'zlodzieja', prawdo: 1, rodzaj: [2], sila: 1 },
    { opis: 'czarodzieja', prawdo: 6, rodzaj: [2], sila: 1 },
    { opis: 'dobrego duszka', prawdo: 5, rodzaj: [2], sila: 1 },
    { opis: 'zlego ducha', prawdo: 5, rodzaj: [2], sila: 1 },
    { opis: 'miecz', prawdo: 2, rodzaj: [3], sila: 1 },
    { opis: 'zbroje', prawdo: 2, rodzaj: [3], sila: 1 },
    { opis: 'magiczny eliksir', prawdo: 4, rodzaj: [3], sila: 1 },
    { opis: 'sztuke miesa', prawdo: 4, rodzaj: [3], sila: 1 },
    { opis: 'zloto', prawdo: 5, rodzaj: [3], sila: 1 },
    { opis: 'trucizne', prawdo: 3, rodzaj: [3], sila: 1 }
    ];

class Bohater {
    wytrzymalosc: number;
    sila: number;
    bagaz: Array<number>; // bagaz: number[];
    zloto: number;
    // potrzebne do edycji strony
    element: HTMLElement;
    span: HTMLElement;

    constructor(element: HTMLElement, wytrzymalosc: number, sila: number, bagaz: number[], zloto: number) {
        this.element = element;
        this.wytrzymalosc = wytrzymalosc;
        this.sila = sila;
        this.bagaz = bagaz;
        this.zloto = zloto;
        this.span = document.createElement('span');
    }

    opiszBohatera() {
        // description
        this.element.innerHTML += "Bohater: wytrzymalosc:" + this.wytrzymalosc + " , bagaz: " + this.bagaz + " , zloto: " + this.zloto;
        this.element.appendChild(this.span);
    }

};

class Zdarzenie {
    opis: string = '';
    prawdo: number = 0;
    rodzaj: Array<number> = [1]; // rodzaj: number[];
    // potrzebne do edycji strony
    element: HTMLElement;
    span: HTMLElement;

    constructor(element: HTMLElement) {
        this.element = element;
        this.span = document.createElement('span');
        //this.element.innerHTML += "Zdarzenie: ";
        //this.span = document.createElement('span');
        //this.element.appendChild(this.span);
        let btnFight = document.getElementById("fight");
        if(btnFight!=null)
        {
            btnFight.addEventListener("click", (e: Event) => this.fight());
        }
        

        let btnFlee = document.getElementById("flee");
        if(btnFlee!=null)
        {
            btnFlee.addEventListener("click", (e: Event) => this.flee());
        }
        

        let btnTalk = document.getElementById("talk");
        if(btnTalk!=null)
        {
            btnTalk.addEventListener("click", (e: Event) => this.talk());
        }
    }

    spotkajWroga(kogo: number) {
        // description
        this.element.innerHTML = "Spotkales: " + swiat[kogo].opis + " , rodzaj: " + swiat[kogo].rodzaj + " , sila: " + swiat[kogo].sila;
        this.span = document.createElement('span');
        this.element.appendChild(this.span);
    }

    spotkajNieznajomego(kogo: number) {
        // description
    }

    znajdzPrzedmiot(jaki: number) {
        // description
    }

    fight(): void {
        alert('fight');
        this.spotkajWroga(Math.floor(Math.random() * 14));
    }

    flee(): void {
    alert('flee');
    }

    talk(): void {
    alert('talk');
    }
};

// Main
window.onload = () => {
  var el = document.getElementById('content');
  var tbl = document.getElementById('tablica');
  var ekran = document.getElementById('ekran');
  var statystyki = document.getElementById('stat');
//   let infoHelper : InfoHelper  = new InfoHelper();
//   InfoHelper.WyswietlInfo();
  // if(el!=null)
  // {
  //   var greeter = new Greeter(el);
  //   greeter.start();
  // }

  if(tbl!=null)
  {

    if(statystyki!=null)
    {
      var bohater = new Bohater(statystyki,1,1,[1],1);
      bohater.opiszBohatera();
    }
    var hafn = new Hafn(tbl);
  }
  
  if(ekran!=null)
  {
    var zdarzenie = new Zdarzenie(ekran);
    var losowanie = Math.floor(Math.random() * 14);
    zdarzenie.spotkajWroga(losowanie);
  }
};
