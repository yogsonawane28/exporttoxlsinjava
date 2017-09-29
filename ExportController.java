  @RequestMapping(value="/export")
	public void getExportFile(Map<String, Object> map,HttpServletRequest request,HttpServletResponse response) {
		InputVO inputVO=null;
    try {
	 if(null!=request.getParameter(RequestParameter.getString("json"))){
		ObjectMapper mapper = auditMapperFactory.getInstance("mapper-instance");
		inputVO =  mapper.readValue(request.getParameter(RequestParameter.getString("json")), InputVO.class);
	 }
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",  Util.stringConcatenate("attachment; filename=",inputVO.fileName," "));
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet=service.getEXCELData(inputs); // this will get data from database and will populate it to excel object 
	        ServletOutputStream outputStream = response.getOutputStream();
	        sheet.getWorkbook().write(outputStream);
	        outputStream.flush();
      	} catch (JsonGenerationException e) {
		LOGGER.error(e.getMessage());		
	} catch (JsonMappingException e) {
		LOGGER.error(e.getMessage());	
	} catch (IOException e) {
		LOGGER.error(e.getMessage());	
	}
		
}
