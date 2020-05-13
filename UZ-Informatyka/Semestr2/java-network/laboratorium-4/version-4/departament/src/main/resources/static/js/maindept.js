/*
*
*/

$(document).ready(function(){
	$('.nBtn, .table .eDeptBtn').on('click', function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	var text = $(this).text();
	if(text=='Edit'){
	$.get(href, function(department,status){
		$('.myForm #id').val(department.id);
		$('.myForm #name').val(department.name);
		$('.myForm #address').val(department.address);
		$('.myForm #mainPhone').val(department.mainPhone);
		$('.myForm #mainMail').val(department.mainMail);
		$('.myForm #mainWWW').val(department.mainWWW);
		$('.myForm #description').val(department.description);
		
	});
	$('.myForm #exampleModal').modal()
	}
	else
	{
		$('.myForm #id').val('');
		$('.myForm #name').val('');
		$('.myForm #address').val('');
		$('.myForm #mainPhone').val('');
		$('.myForm #mainMail').val('');
		$('.myForm #mainWWW').val('');
		$('.myForm #description').val('');
		
		$('.myForm #exampleModal').modal()
	}
	});
	
		$('.table .delDeptBtn').on('click', function(event){
			event.preventDefault();
			var href = $(this).attr('href');
			$('#myModaldept #delRef').attr('href',href);
			$('#myModaldept').modal();
		});
});