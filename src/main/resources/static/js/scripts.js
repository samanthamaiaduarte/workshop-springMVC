const tooltipList = document.querySelectorAll('[rel="tooltip"]')
const tooltips = [...tooltipList].map(tooltip => new bootstrap.Tooltip(tooltip))

$('.js-currency').maskMoney({thousands:'.', decimal:','})

$('.js-atualizarStatus').on('click', function(event) {
	event.preventDefault()
	
	const button = $(event.currentTarget)
	const url = button.attr('href')
	
	const response = $.ajax({
		url: url,
		type: 'PUT'
	})
	
	response.done(function(e) {
		const idTitulo = button.data('codigo')
		$('[data-role=' + idTitulo + ']').html('<span class="badge text-bg-success">' + e + '</span>')
		button.hide()
	})
	
	response.fail(function(e) {
		
	})
	
})	

const dialogModal = document.getElementById('dialogoExclusao')

if (dialogModal) {
  dialogModal.addEventListener('show.bs.modal', event => {
    const button = event.relatedTarget

    const idTitulo = button.getAttribute('data-codigo')
    const form = dialogModal.getElementsByTagName('form')[0]
	const urlBase = form.getAttribute('data-urlbase')
	
	form.setAttribute('action', urlBase + (!urlBase.endsWith('/') ? '/' : '') + idTitulo)
    
    const descTitulo = button.getAttribute('data-descricao')
    const modalLabel = dialogModal.querySelector('.modal-body label')
    modalLabel.innerHTML = '<strong>' + descTitulo + '</strong>?'
  })
}

$(document).ready(function(){			
    setTimeout(function() {
	$(".alert-success").fadeOut("slow", function(){
		$(this).alert('close');
	});				
    }, 3000);			
});