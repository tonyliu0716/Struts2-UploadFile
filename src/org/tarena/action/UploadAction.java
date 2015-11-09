package org.tarena.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.tarena.util.FileUtil;

public class UploadAction {
	//接收传入的临时文件
	private File some;
	//接收原始文件名 该变量名必须这样取名：input的name属性＋FileName
	private String someFileName;
	
	public String execute() {
		if(some == null) {
			return "error";
		}
		//将文件放在项目部署路径下的upload文件夹
		String path = "WEB-INF/upload/" + someFileName;
		//根据相对部署路径计算完整路径
		path = ServletActionContext.getServletContext().getRealPath(path);
		System.out.println(path);
		//将临时文件复制到上述路径下
		FileUtil.copy(some, new File(path));
		return "success";
	}
	
	public File getSome() {
		return some;
	}
	public void setSome(File some) {
		this.some = some;
	}
	public String getSomeFileName() {
		return someFileName;
	}
	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}
	
	
}
