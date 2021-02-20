package com.bng.zbp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bng.zbp.model.response.ApiStatusRes;
import com.bng.zbp.util.URIConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileUpload {
	private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	private static final Gson gson = new GsonBuilder().serializeNulls().create();
	ApiStatusRes apiStatusRes = new ApiStatusRes();

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {
		String filename = file.getOriginalFilename();
		logger.info("filename" + filename);
		Long size = file.getSize();
		logger.info("filename" + filename + " size: " + size);

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		String tableTimeDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String name = "filename" + tableTimeDate + "." + extension;
		logger.info("FILE IS NOT EMPTY");
		if (!file.isEmpty()) {
			logger.info("UPLOAD FILE REQUEST" + extension);
			try {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(URIConstants.URLTOUPLOADFILE + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("FileName" + name + "exteensionnnn" + extension);
				File filesp = new File(URIConstants.URLTOUPLOADFILE + name);
				filesp.setExecutable(true, false);
				filesp.setReadable(true, false);
				filesp.setWritable(true, false);
				apiStatusRes.setResponse(name);
				if (extension.endsWith("xlsx")) {
					ArrayList<String> heading = new ArrayList<String>();
					ArrayList<String> firstrow = new ArrayList<String>();
					FileInputStream fis = null;
					logger.info("Inside If" + extension);
					try {
						logger.info("Inside Try" + URIConstants.URLTOUPLOADFILE + name);
						fis = new FileInputStream(URIConstants.URLTOUPLOADFILE + name);
						Workbook workbook = new XSSFWorkbook(fis);
						int numberOfSheets = workbook.getNumberOfSheets();
						for (int i = 0; i < numberOfSheets; i++) {
							Sheet sheet = workbook.getSheetAt(i);
							Iterator rowIterator = sheet.iterator();
							int j = 0;
							while (rowIterator.hasNext()) {
								Row row = (Row) rowIterator.next();
								Iterator cellIterator = row.cellIterator();
								while (cellIterator.hasNext()) {
									Cell cell = (Cell) cellIterator.next();
									if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
										logger.info("String cell Name" + cell.getStringCellValue());
										if (j == 0)
											heading.add(cell.getStringCellValue());
										if (j == 1)
											firstrow.add(cell.getStringCellValue());

									} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {

									}
								}
								if (j == 2) {
									break;
								}
								j++;
							}
							logger.info("Loop Count" + i);
						}
						fis.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					apiStatusRes.setHeading(heading);
					apiStatusRes.setFirstrow(firstrow);

				} else {
					logger.info("Inside else");
				}

				return gson.toJson(apiStatusRes);
			} catch (Exception e) {
				logger.info("FILE Exception");
				logger.error("exception found in file" + e.getMessage());
				logger.error("exception found in file" + e.getStackTrace());

				apiStatusRes.setResponse("fail");
				return gson.toJson(apiStatusRes);
			}
		} else {
			logger.info("FILE IS  EMPTY");
			apiStatusRes.setResponse("fail");
			return gson.toJson(apiStatusRes);
		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {
		logger.info("get" + gson.toJson(files));

		List<ApiStatusRes> apiStatusResList = new ArrayList();
		if (files.length < 0)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			ApiStatusRes apiStatusRes = new ApiStatusRes();
			MultipartFile file = files[i];
			String random = UUID.randomUUID().toString().substring(6, 10);
			String name = files[i].getOriginalFilename();
			String extension = FilenameUtils.getExtension(files[i].getOriginalFilename());
			String tableTimeDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			String finalname = "filename" + tableTimeDate + random + "." + extension;
			logger.info("name" + name + "extension" + extension + "finalname" + finalname + "len" + files.length);
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");

				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(URIConstants.URLTOUPLOADFILE + finalname);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("FileName" + name + "exteensionnnn" + extension);
				File filesp = new File(URIConstants.URLTOUPLOADFILE + finalname);
				filesp.setExecutable(true, false);
				filesp.setReadable(true, false);
				filesp.setWritable(true, false);

				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				apiStatusRes.setResponse(name);
				apiStatusRes.setKey(finalname);
				apiStatusResList.add(apiStatusRes);

			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}

		return gson.toJson(apiStatusResList);
	}
}
