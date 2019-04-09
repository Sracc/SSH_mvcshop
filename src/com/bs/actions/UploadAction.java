package com.bs.actions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends BaseAction {
	private File[] uploadFile;
	private String[] fileName;
	private String[] contentType;

	public String execute() {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		
		JSONObject json = new JSONObject();
		json.put("nums", uploadFile.length);
		JSONArray contentTypes=new JSONArray();
		JSONArray filenames=new JSONArray();
		
		for(int i=0;i<uploadFile.length;i++) {  
			String realPath = null;
			if (contentType[i] != null) {
				if (contentType[i].toLowerCase().indexOf("image") > -1) {
					realPath = application.getRealPath("/upload_image");
				} else {
					realPath = application.getRealPath("/upload_file");
				}
			}
			String ext = fileName[i].substring(fileName[i].lastIndexOf("."));
			String finalFilename = new SimpleDateFormat("yyyyMMddHHmmssms"+i).format(new Date()) + ext;
			try {
				FileUtils.copyFile(uploadFile[i], new File(realPath + "/"+ finalFilename));// 异常
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			contentTypes.add(contentType[i]);
			filenames.add(finalFilename);
        }  
		
		json.put("contentTypes", contentTypes);
		json.put("filenames", filenames);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json.toJSONString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}


	public File[] getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}


	// 接收上传文件的文件名
	public void setUploadFileFileName(String[] fName) {
		fileName = fName;
	}

	// 接收上传文件的类型
	public void setUploadFileContentType(String[] ct) {
		contentType = ct;
	}

	
}
