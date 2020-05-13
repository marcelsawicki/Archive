$(document).ready(function(){
	$('.nBtn, .table .eWniosekUrlopowyBtn').on('click', function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	var text = $(this).text();
	if(text=='Edytuj'){
	$.get(href, function(wniosekurlopowy,status){
		$('.formWniosekUrlopowy #id').val(wniosekurlopowy.id);
		$('.formWniosekUrlopowy #name').val(wniosekurlopowy.name);
		if(wniosekurlopowy.pracownik!=undefined)
		{
			$('.formWniosekUrlopowy #pracownik').val(wniosekurlopowy.pracownik.id);
		}
		else
		{
			$('.formWniosekUrlopowy #pracownik').val(wniosekurlopowy.pracownik);
		}
		
		$('.formWniosekUrlopowy #status').val(wniosekurlopowy.status);
		$('.formWniosekUrlopowy #odkiedy').val(wniosekurlopowy.odkiedy);
		$('.formWniosekUrlopowy #dokiedy').val(wniosekurlopowy.dokiedy);

	});
	$('.formWniosekUrlopowy #edycjaModal').modal()
	}
	else
	{
		$('.formWniosekUrlopowy #id').val('');
		$('.formWniosekUrlopowy #name').val('');
		$('.formWniosekUrlopowy #status').val('OCZEKUJE');
		$('.formWniosekUrlopowy #odkiedy').val('');
		$('.formWniosekUrlopowy #dokiedy').val('');
		
		$('.formWniosekUrlopowy #edycjaModal').modal()
	}
	});
	
	$('.table .delWniosekUrlopowyBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModalWniosekUrlopowy #delRef').attr('href',href);
		$('#deleteModalWniosekUrlopowy').modal();
	});
});