"use strict";
var Greeter = /** @class */ (function () {
    function Greeter(element) {
        this.element = element;
        this.element.innerHTML += "The time is: ";
        this.span = document.createElement('span');
        this.element.appendChild(this.span);
        this.span.innerText = new Date().toUTCString();
        this.timerToken = 0;
    }
    Greeter.prototype.start = function () {
        var _this = this;
        this.timerToken = setInterval(function () { return _this.span.innerHTML = new Date().toUTCString(); }, 500);
    };
    Greeter.prototype.stop = function () {
        clearTimeout(this.timerToken);
    };
    return Greeter;
}());
var Hafn = /** @class */ (function () {
    function Hafn(element) {
        this.list = ['miecz', 'zbroja', 'wlocznia']; // dopisalem
        this.element = element;
        var kostkaDoGry = Math.floor(Math.random() * 3);
        var numerNaStrone = this.list[kostkaDoGry];
        this.element.innerHTML += "Wybieram z tablicy: " + numerNaStrone + ". ";
        this.element.innerHTML += "Losuje jakas wartosc od 0 do 100: " + Math.floor(Math.random() * 100);
        this.span = document.createElement('span');
        this.element.appendChild(this.span);
        this.timerToken = 0;
        // this.span.innerText = new Date().toUTCString();
    }
    Hafn.prototype.start = function () {
        var _this = this;
        this.timerToken = setInterval(function () { return _this.span.innerHTML = new Date().toUTCString(); }, 500);
    };
    Hafn.prototype.stop = function () {
        clearTimeout(this.timerToken);
    };
    return Hafn;
}());
var r_zdarzenia = ['wrog', 'nieznajomy', 'przedmiot', 'nic'];
var r_nieznajomego = ['zlodziej', 'dobry_d', 'zly_d', 'czarodziej'];
var r_przedmiotu = ['miecz', 'zbroja', 'eliksir', 'mieso', 'zloto', 'trucizna'];
var OpisSwiata = /** @class */ (function () {
    function OpisSwiata() {
        this.opis = '';
        this.prawdo = 0;
        this.rodzaj = [1];
        this.sila = 0;
    }
    return OpisSwiata;
}());
var swiat = [
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
var Bohater = /** @class */ (function () {
    function Bohater(element, wytrzymalosc, sila, bagaz, zloto) {
        this.element = element;
        this.wytrzymalosc = wytrzymalosc;
        this.sila = sila;
        this.bagaz = bagaz;
        this.zloto = zloto;
        this.span = document.createElement('span');
    }
    Bohater.prototype.opiszBohatera = function () {
        // description
        this.element.innerHTML += "Bohater: wytrzymalosc:" + this.wytrzymalosc + " , bagaz: " + this.bagaz + " , zloto: " + this.zloto;
        this.element.appendChild(this.span);
    };
    return Bohater;
}());
;
var Zdarzenie = /** @class */ (function () {
    function Zdarzenie(element) {
        var _this = this;
        this.opis = '';
        this.prawdo = 0;
        this.rodzaj = [1]; // rodzaj: number[];
        this.element = element;
        this.span = document.createElement('span');
        //this.element.innerHTML += "Zdarzenie: ";
        //this.span = document.createElement('span');
        //this.element.appendChild(this.span);
        var btnFight = document.getElementById("fight");
        if (btnFight != null) {
            btnFight.addEventListener("click", function (e) { return _this.fight(); });
        }
        var btnFlee = document.getElementById("flee");
        if (btnFlee != null) {
            btnFlee.addEventListener("click", function (e) { return _this.flee(); });
        }
        var btnTalk = document.getElementById("talk");
        if (btnTalk != null) {
            btnTalk.addEventListener("click", function (e) { return _this.talk(); });
        }
    }
    Zdarzenie.prototype.spotkajWroga = function (kogo) {
        // description
        this.element.innerHTML = "Spotkales: " + swiat[kogo].opis + " , rodzaj: " + swiat[kogo].rodzaj + " , sila: " + swiat[kogo].sila;
        this.span = document.createElement('span');
        this.element.appendChild(this.span);
    };
    Zdarzenie.prototype.spotkajNieznajomego = function (kogo) {
        // description
    };
    Zdarzenie.prototype.znajdzPrzedmiot = function (jaki) {
        // description
    };
    Zdarzenie.prototype.fight = function () {
        alert('fight');
        this.spotkajWroga(Math.floor(Math.random() * 14));
    };
    Zdarzenie.prototype.flee = function () {
        alert('flee');
    };
    Zdarzenie.prototype.talk = function () {
        alert('talk');
    };
    return Zdarzenie;
}());
;
// Main
window.onload = function () {
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
    if (tbl != null) {
        if (statystyki != null) {
            var bohater = new Bohater(statystyki, 1, 1, [1], 1);
            bohater.opiszBohatera();
        }
        var hafn = new Hafn(tbl);
    }
    if (ekran != null) {
        var zdarzenie = new Zdarzenie(ekran);
        var losowanie = Math.floor(Math.random() * 14);
        zdarzenie.spotkajWroga(losowanie);
    }
};
