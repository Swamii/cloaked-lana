function clearForm(formName) {
	console.log('clearing form ' + formName);
	$("#" + formName).find('input:text').val('');
}