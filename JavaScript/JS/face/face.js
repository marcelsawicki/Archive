var counter=0;

var MessageItem = function(msg,likes)
{
	this.msg = msg;
	this.like = likes;
}

var LikeButton = function(id)
{
	debugger;
	console.log('like');
}

var UnlikeButton = function(e)
{
	console.log('unlike');
}

var addMessage = function(e) 
{
	counter++;
	console.log('add message');
	var main2 = document.getElementById("main");
	var div1 = document.createElement('div');
	div1.setAttribute('id',counter);
	var p1 = document.createElement('p')
	var msg1 = document.getElementById('msg');
	
	p1.innerText = msg.value;
	
	var input1 = document.createElement('input');
	input1.setAttribute('id',counter);
	input1.setAttribute('type','button');
	input1.setAttribute('value','Like');
	input1.addEventListener('click',function(e){LikeButton(this.id)},false)
	div1.appendChild(input1);
	
	var input2 = document.createElement('input');
	input2.setAttribute('id',counter);
	input2.setAttribute('type','button');
	input2.setAttribute('value','Unlike');
	input2.addEventListener('click',UnlikeButton,false)
	div1.appendChild(input2);
	div1.appendChild(p1);
	main2.appendChild(div1);
}

var main1 = document.getElementById("main");
var textarea1 = document.createElement('textarea');
textarea1.setAttribute('id','msg');
textarea1.setAttribute('rows','5');
textarea1.setAttribute('cols','20');
main1.appendChild(textarea1);


var input1 = document.createElement('input');
input1.setAttribute('class','btn btn-outline-secondary');
input1.setAttribute('value','Send message');
main1.appendChild(input1);
input1.addEventListener('click',addMessage,false)


var messageInstance = new MessageItem('example message',123)
