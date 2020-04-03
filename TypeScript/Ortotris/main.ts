import { Greeter } from "./app"
import { Wybory } from "./app"

window.onload = () => {

  var nacisnij = function(e) {
    e = e || window.event; // IE
		if (e.which === 37) { // lewa
			return;
		}
		
		if (e.which === 39) { // prawa
			return;
		}
  }

  let r = 25;
  let el = document.getElementById('content');
  let pobieramTablice = document.getElementById('tablica');
  pobieramTablice.innerHTML = 'wie_a';
  let pobieramKlawisz = new Wybory(); 
  // window.onkeydown = function(e){console.log(e)};
  window.onkeydown = (e:Event)=>{console.log(e); pobieramKlawisz.nacisnietyKlawisz(e, el, pobieramTablice, r);};


  
setInterval(function() {
  this.ekran = document.getElementById("ekran");
  let context: CanvasRenderingContext2D = this.ekran.getContext('2d');
  this.ekran["width"]=400;
  this.ekran["height"]=400;
 r = pobieramKlawisz.pobierzPromien(r);
  context.beginPath();
  context.arc(100, 105, r, 0, Math.PI*2, false);
context.stroke();
  }, 30);
};