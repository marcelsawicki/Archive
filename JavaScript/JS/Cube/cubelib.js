function przeliczX(xa, ya, za)
{
	var fi=fia;
	var teta=fia;
	var wsp_x=160;
	var wsp_y=120;
	var skala=5;
	var dist=25;
	
	var xn=-Math.sin(fi*Math.PI/180)*xa+Math.cos(fi*Math.PI/180)*ya;
	var yn=-Math.cos(fi*Math.PI/180)*xa-Math.sin(fi*Math.PI/180)*ya+Math.sin(teta*Math.PI/180)*za;
	var zn=-Math.cos(fi*Math.PI/180)*Math.sin(teta*Math.PI/180)*ya-Math.cos(teta*Math.PI/180)*za+dist;
	 var x=skala*xn/(zn+dist)+wsp_x;
	 var y=skala*yn/(zn+dist)+wsp_y;
	 
	 xp = xa + za*(Math.cos((teta*Math.PI/180))*0.5);
	return xp*skala;
}

function przeliczY(xa, ya, za)
{
	var fi=fia;
	var teta=fia;
	var wsp_x=160;
	var wsp_y=120;
	var skala=5;
	var dist=25;
	
	var xn=-Math.sin(fi*Math.PI/180)*xa+Math.cos(fi*Math.PI/180)*ya;
	var yn=-Math.cos(fi*Math.PI/180)*xa-Math.sin(fi*Math.PI/180)*ya+Math.sin(teta*Math.PI/180)*za;
	var zn=-Math.cos(fi*Math.PI/180)*Math.sin(teta*Math.PI/180)*ya-Math.cos(teta*Math.PI/180)*za+dist;
	 var x=skala*xn/(zn+dist)+wsp_x;
	 var y=skala*yn/(zn+dist)+wsp_y;
	 yp = ya + za *(Math.sin((teta*Math.PI/180))*0.5);
	return yp*skala;
}

function draw(fia)
{
	window.fia = fia;
		var canvas = document.getElementById('kanwa');
	var context = canvas.getContext('2d');
	context.clearRect(0, 0, 320, 240);	
	    // clear path
    context.beginPath();
	context.fillStyle = "blue";

	context.fillRect(0, 0, canvas.width, canvas.height);
	
	  
	  context.moveTo(przeliczX(10,10,0), przeliczY(10,10,0));
      context.lineTo(przeliczX(10,20,0), przeliczY(10,20,0));
      context.stroke();
	  
	  context.moveTo(przeliczX(20,10,0), przeliczY(20,10,0));
      context.lineTo(przeliczX(20,20,0), przeliczY(20,20,0));
      context.stroke();
	  
	  context.moveTo(przeliczX(20,20,0), przeliczY(20,20,0));
      context.lineTo(przeliczX(10,20,0), przeliczY(10,20,0));
      context.stroke();
	  
	  context.moveTo(przeliczX(20,10,0), przeliczY(20,10,0));
      context.lineTo(przeliczX(10,10,0), przeliczY(10,10,0));
	  context.strokeStyle = 'white';
      context.stroke();

	  //
	  
	  context.moveTo(przeliczX(20,20,0), przeliczY(20,20,0));
      context.lineTo(przeliczX(20,20,10), przeliczY(20,20,10));
      context.stroke();
	  
	  context.moveTo(przeliczX(20,20,10), przeliczY(20,20,10));
      context.lineTo(przeliczX(20,10,10), przeliczY(20,10,10));
      context.stroke();
	  
	  context.moveTo(przeliczX(20,10,10), przeliczY(20,10,10));
      context.lineTo(przeliczX(20,10,0), przeliczY(20,10,0));
      context.stroke();
	  
	  //
	  
	  context.moveTo(przeliczX(20,10,10), przeliczY(20,10,10));
      context.lineTo(przeliczX(10,10,10), przeliczY(10,10,10));
      context.stroke();
	  
	  context.moveTo(przeliczX(10,10,10), przeliczY(10,10,10));
      context.lineTo(przeliczX(10,10,0), przeliczY(10,10,0));
      context.stroke();
	  
	  context.moveTo(przeliczX(10,10,10), przeliczY(10,10,10));
      context.lineTo(przeliczX(10,20,10), przeliczY(10,20,10));
      context.stroke();
	  
	  //
	  
	  context.moveTo(przeliczX(10,20,10), przeliczY(10,20,10));
      context.lineTo(przeliczX(10,20,0), przeliczY(10,20,0));
      context.stroke();
	  
	  context.moveTo(przeliczX(10,20,10), przeliczY(10,20,10));
      context.lineTo(przeliczX(20,20,10), przeliczY(20,20,10));
      context.stroke();	
}