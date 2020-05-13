$(document).ready(function(){
	$('.nBtn, .table .ePracownikBtn').on('click', function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	var text = $(this).text();
	if(text=='Edytuj'){
	$.get(href, function(pracownik,status){
		$('.formPracownik #id').val(pracownik.id);
		$('.formPracownik #name').val(pracownik.name);
		$('.formPracownik #surname').val(pracownik.surname);
		$('.formPracownik #status').val(pracownik.status);

	});
	$('.formPracownik #edycjaModal').modal()
	}
	else
	{
		$('.formPracownik #id').val('');
		$('.formPracownik #name').val('');
		$('.formPracownik #surname').val('');
		$('.formPracownik #status').val('');
		
		$('.formPracownik #edycjaModal').modal()
	}
	});
	
	$('.table .delPracownikBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModalPracownik #delRef').attr('href',href);
		$('#deleteModalPracownik').modal();
	});
});