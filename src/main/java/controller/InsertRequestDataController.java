package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logger.SagimaraLogger;
import org.apache.log4j.Logger;

import database.DatabaseHandler;
import framework.JsonBuilder;

public class InsertRequestDataController implements Controller {
	Logger logger;
	DatabaseHandler db;
	JsonBuilder jb;
	
	public InsertRequestDataController() {
		super();
		this.logger = SagimaraLogger.logger;
		this.db = new DatabaseHandler();
		this.jb = new JsonBuilder();
	}
	
	public void run(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		logger.info("Content-type : " + request.getHeader("Content-type"));

	}
}