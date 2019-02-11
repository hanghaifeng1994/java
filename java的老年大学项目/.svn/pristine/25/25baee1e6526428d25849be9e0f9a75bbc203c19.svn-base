package cn.com.weyeyun.commoncert.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.weyeyun.commoncert.core.UserCertOfflineManager;

import com.google.common.collect.Lists;

public class ImportUserCertOfflineThread extends Thread {
	public ServletContext servletContext;
	public static String message;
	public List<Map<String, String>> datas;
	public static Map<String, List<Long>> map = new HashMap<String, List<Long>>();
	public static Map<String, String> isOver = new HashMap<String, String>();
	public String fileName;
	private Long certId;
	private int importType;
	private String tenantId;
	public String threadName;
	private String uploadPath;

	public ImportUserCertOfflineThread(String uploadPath, List<Map<String, String>> datas, String fileName, Long certId, int importType, String tenantId) {
		this.uploadPath = uploadPath;
		this.datas = datas;
		this.fileName = fileName;
		this.certId = certId;
		this.importType = importType;
		this.tenantId = tenantId;
	}

	@Override
	public void run() {
		System.out.println("{{{ run start}}}");
		try {
			this.saveimport();
		} catch (Exception e) {
			e.printStackTrace();
			isOver.remove(threadName);
			System.out.println("{{{ run error " + e.getMessage() + "}}}");
		}
		System.out.println("{{{ run out}}}");
	}

	private void saveimport() throws Exception {
		System.out.println("{{{ run saveimport 1}}}");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
		UserCertOfflineManager userCertOfflineManager = (UserCertOfflineManager) wac.getBean("userCertOfflineManager");
		List<String> errorKeyList = new ArrayList<String>();
		errorKeyList.add("错误行号");
		errorKeyList.add("姓名");
		errorKeyList.add("错误原因");

		// 不生成文件，直接生成文件输出流供下载
		ExcelModel excel = new ExcelModel();
		List<List<Object>> result = Lists.newArrayList();
		excel.setHeader(errorKeyList);
		excel.setSheetName("导入证书错误信息");

		datas = datas.subList(1, datas.size());
		result = userCertOfflineManager.saveImportOfflineCert(datas, threadName, result, certId, importType, tenantId);

		if (result.size() <= 0) {
			List<Object> objlist = Lists.newArrayList();
			objlist.add("数据全部导入成功！");
			result.add(objlist);
		}
		excel.setData(result);
		BaseExcelDownLoad.write(uploadPath, this.fileName, excel);
		isOver.remove(threadName);
		System.out.println("{{{ 导入用户  end}}}" + message + "----");
	}
}
