function export(exportType) {
  var controllerUrl = "export";
  var data=''; // This will be data object that you may need to send backend  
  var jsonObj {
    'type':exportType,
    'data' : data
  }
	var jsonString = JSON.stringify(jsonObj);
	var url = controllerUrl + '?json=' + encodeURIComponent(jsonString);
	$('.export-csv-xls').attr('target', '_blank');
	$('.export-csv-xls').attr('href', url);
}
