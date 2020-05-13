/*
*
*/

$(document).ready(function(){
	$('.nBtn, .table .eUsrBtn').on('click', function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	var text = $(this).text();
	if(text=='Edit'){
	$.get(href, function(app_user,status){
		$('.myForm #id').val(app_user.id);
		$('.myForm #department').val(app_user.department);
		$('.myForm #department').val('');
		$('.myForm #username').val(app_user.username);
		$('.myForm #password').val(app_user.password);
		$('.myForm #firstName').val(app_user.firstName);
		$('.myForm #lastName').val(app_user.lastName);
		$('.myForm #description').val(app_user.description);
		$('.myForm #pay').val(app_user.pay);
		$('.myForm #bonus').val(app_user.bonus);
		$('.myForm #dayOfPaymant').val(app_user.dayOfPaymant);
		
	});
	$('.myForm #exampleModal').modal()
	}
	else
	{
		$('.myForm #id').val('');
		$('.myForm #department').val('');
		$('.myForm #username').val('');
		$('.myForm #password').val('');
		$('.myForm #firstName').val('');
		$('.myForm #lastName').val('');
		$('.myForm #description').val('');
		$('.myForm #pay').val('');
		$('.myForm #bonus').val('');
		$('.myForm #dayOfPaymant').val('');
		
		$('.myForm #exampleModal').modal()
	}
	});
	
		$('.table .delUsrBtn').on('click', function(event){
			event.preventDefault();
			var href = $(this).attr('href');
			$('#myModalusr #delRef').attr('href',href);
			$('#myModalusr').modal();
		});
});