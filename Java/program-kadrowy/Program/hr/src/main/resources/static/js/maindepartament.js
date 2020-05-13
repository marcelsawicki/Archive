$(document).ready(function(){
	$('.nBtn, .table .eDepartamentBtn').on('click', function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	var text = $(this).text();
	if(text=='Edytuj'){
	$.get(href, function(departament,status){
		$('.formDepartament #id').val(departament.id);
		$('.formDepartament #name').val(departament.name);
		$('.formPracownik #status').val(departament.status);

	});
	$('.formDepartament #edycjaModal').modal()
	}
	else
	{
		$('.formDepartament #id').val('');
		$('.formDepartament #name').val('');
		$('.formDepartament #status').val('');
		
		$('.formDepartament #edycjaModal').modal()
	}
	});
	
	$('.table .delDepartamentBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModalDepartament #delRef').attr('href',href);
		$('#deleteModalDepartament').modal();
	});
});