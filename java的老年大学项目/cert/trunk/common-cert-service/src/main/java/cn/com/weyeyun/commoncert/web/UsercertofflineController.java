package cn.com.weyeyun.commoncert.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springside.modules.orm.Page;

import cn.com.weyeyun.commoncert.constains.Constants;
import cn.com.weyeyun.commoncert.core.CertManager;
import cn.com.weyeyun.commoncert.core.CertTemplateManager;
import cn.com.weyeyun.commoncert.core.UserCertOfflineManager;
import cn.com.weyeyun.commoncert.dto.CertDTO;
import cn.com.weyeyun.commoncert.dto.PropertyAll;
import cn.com.weyeyun.commoncert.dto.UserCertOfflineDTO;
import cn.com.weyeyun.commoncert.util.FileUploadUtils;
import cn.com.weyeyun.commoncert.util.ImportUserCertOfflineThread;
import cn.common.lib.springside.orm.ExtPropertyFilter;
import cn.common.lib.springside.orm.page.ExtPage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@RestController
@RequestMapping(value = "/cert/usercertoffline")
public class UsercertofflineController {

	@Autowired
	private CertTemplateManager certTemplateManager;

	@Autowired
	private CertManager certManager;

	@Autowired
	private UserCertOfflineManager userCertOfflineManager;

	@Value("${traincore.uploadpath}")
	private String uploadPath;

	@Value("${traincore.uploadpath}")
	private static String uploadPath2;

	@Value("${traincore.uploadpath.url}")
	private String uploadUrl;

	@Autowired
	private PropertyAll property;

	private static Map<Long, Map<String, Object>> fileRandom = Maps.newHashMap();

	@RequestMapping("/manage/certs")
	public Object certs() {
		List<CertDTO> certs = certManager.getCertByType(1, null);
		JSONArray result = JSONArray.fromObject(certs);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/list")
	public Object list(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, Long certId, String startTime, String endTime, String unit, String name, String mobilePhone, String certno,
			Boolean published) {
		Page<UserCertOfflineDTO> page = new ExtPage<UserCertOfflineDTO>(20);
		page.setPageNo(pageNo);
		// 设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.DESC);
		}
		List<ExtPropertyFilter> filters = Lists.newArrayList();
		if (certId != null) {
			filters.add(new ExtPropertyFilter("EQL_id", String.valueOf(certId), "cert"));
		}
		if (published != null) {
			filters.add(new ExtPropertyFilter("EQB_published", published + ""));
		}

		if (StringUtils.isNotBlank(unit)) {
			unit = unit.trim();
			unit = "%" + unit + "%";
			filters.add(new ExtPropertyFilter("LIKES_unit", unit));
		}

		if (StringUtils.isNotBlank(name)) {
			name = name.trim();
			name = "%" + name + "%";
			filters.add(new ExtPropertyFilter("LIKES_name", name));
		}

		if (StringUtils.isNotBlank(mobilePhone)) {
			mobilePhone = mobilePhone.trim();
			mobilePhone = "%" + mobilePhone + "%";
			filters.add(new ExtPropertyFilter("LIKES_mobilePhone", mobilePhone));
		}

		if (StringUtils.isNotBlank(certno)) {
			certno = certno.trim();
			certno = "%" + certno + "%";
			filters.add(new ExtPropertyFilter("LIKES_certno", certno));
		}

		try {
			ConvertUtils.register(new Converter() {
				public Object convert(Class type, Object value) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						return simpleDateFormat.parse(value.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				}
			}, Date.class);
			if (StringUtils.isNotBlank(startTime)) {
				// filters.add(new ExtPropertyFilter("GED_genTime",
				// sf.parse(startTime+" 00:00:00").getTime()+""));
				filters.add(new ExtPropertyFilter("GED_genTime", startTime));
			}

			if (StringUtils.isNotBlank(endTime)) {
				// filters.add(new ExtPropertyFilter("LED_genTime",
				// sf.parse(endTime).getTime()+""));
				filters.add(new ExtPropertyFilter("LED_genTime", endTime));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		page = userCertOfflineManager.extSearch(page, filters);
		JSONObject result = JSONObject.fromObject(page);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/info")
	public Object info(String id) throws IOException {
		/*
		 * String imgPath = userCertOfflineManager.getUserCertPath(id); String
		 * imgName = imgPath.substring(imgPath.lastIndexOf("/")+1); String
		 * fileName = imgName.substring(0,imgName.indexOf("."))+"-small"; String
		 * endFix = imgName.substring(imgName.indexOf(".")); String newImageName
		 * = fileName+endFix; String newFilePath = imgPath.replace(imgName,
		 * newImageName); File originalFile = new File(imgPath); File
		 * resizedFile = new File(newFilePath); System.out.println(newFilePath);
		 * ImageSizer.imageResize(originalFile, resizedFile, 500, 1f); //imgUrl
		 * = Constants.USERCERTPATH+ "/" +newImageName; String imgUrl =
		 * uploadUrl + Constants.USERCERTPATH+ "/" +newImageName; JSONObject
		 * result = new JSONObject(); result.put("imgUrl", imgUrl); return
		 * "successCallback(" + result.toString() + ")";
		 */
		UserCertOfflineDTO usercert = userCertOfflineManager.get(id);
		JSONObject result = JSONObject.fromObject(usercert);
		return "successCallback(" + result.toString() + ")";

	}

	@RequestMapping("/manage/publish")
	public Object publish(String ids) {
		Long[] pids = (Long[]) ConvertUtils.convert(ids.split(","), Long.class);
		userCertOfflineManager.publish(pids);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/unpublish")
	public Object unpublish(String ids) {
		Long[] pids = (Long[]) ConvertUtils.convert(ids.split(","), Long.class);
		userCertOfflineManager.unpublish(pids);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/downloadUserCertOffline")
	public void downloadUserCertOffline(Long id, HttpServletRequest request, HttpServletResponse response) {
		String imgPath = userCertOfflineManager.getUserCertPath(id);
		String imgName = imgPath.substring(imgPath.lastIndexOf("/") + 1);
		InputStream is = null;
		OutputStream out = null;
		try {
			is = new FileInputStream(imgPath);
			int data = -1;
			out = response.getOutputStream();
			response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(imgName, "UTF-8"));
			response.setContentType("application/x-download");
			while ((data = is.read()) != -1) {
				out.write(data);
			}

			// out.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
					response.flushBuffer();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@RequestMapping("/manage/upload")
	public Object upload(@RequestParam("upload") MultipartFile file, @RequestParam("certId") Long certId, Long random, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> returnMap = Maps.newHashMap();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

		String fileName = file.getOriginalFilename();
		String importSavePath = uploadPath + File.separator + Constants.USERCERTSAVEIMPORTERROR + File.separator;
		fileName = sf.format(new Date()) + fileName;
		try {
			FileUploadUtils.uploadFile(file.getBytes(), importSavePath, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		File uploadFile = new File(importSavePath + fileName);

		String message;
		List<String> fileTypes = Lists.newArrayList();
		// 文件类型最好全部用小写
		fileTypes.add("xls");
		fileTypes.add("xlsx");
		// 判断文件类型
		message = FileUploadUtils.fileTypeValidate(fileName, uploadFile, fileTypes, 50 * 1024);
		if (null != message) {
			returnMap.put("msg", message);
			returnMap.put("success", false);
			fileRandom.put(random, returnMap);
			JSONObject result = JSONObject.fromObject(returnMap);
			return "successCallback(" + result.toString() + ")";
		}

		// 读取数据
		List<String> keyList = new ArrayList<String>();
		keyList.add("工作单位");
		keyList.add("姓名");
		keyList.add("手机号码");
		keyList.add("证书编号");
		keyList.add("身份证号码");
		keyList.add("培训科目");
		keyList.add("学分");
		keyList.add("培训年度");
		keyList.add("年");
		keyList.add("月");
		keyList.add("日");
		keyList.add("第一列");
		keyList.add("第二列");
		keyList.add("第三列");
		keyList.add("第四列");
		keyList.add("第五列");
		keyList.add("第六列");
		keyList.add("第七列");
		keyList.add("第八列");
		keyList.add("第九列");
		keyList.add("第十列");
		List<Map<String, String>> datas = Lists.newArrayList();
		// 读取excel
		datas = FileUploadUtils.getDataFromFile(fileName, keyList, uploadFile);
		if (datas == null) {
			returnMap.put("msg", "文件读取错误");
			returnMap.put("success", false);
			fileRandom.put(random, returnMap);
			JSONObject result = JSONObject.fromObject(returnMap);
			return "successCallback(" + result.toString() + ")";
		}
		String importFileName = "UserCertSaveImportExport_" + sf.format(new Date()) + ".xls";
		ImportUserCertOfflineThread thread = new ImportUserCertOfflineThread(importSavePath, datas, importFileName, certId, 1, null);
		thread.threadName = thread.getName();
		thread.servletContext = request.getSession().getServletContext();
		ImportUserCertOfflineThread.isOver.put(thread.threadName, null);
		ImportUserCertOfflineThread.map.put(thread.threadName, null);
		thread.start();
		returnMap.put("success", "true");
		returnMap.put("threadName", thread.threadName);
		returnMap.put("fileName", uploadUrl + Constants.USERCERTSAVEIMPORTERROR + "/" + importFileName);
		fileRandom.put(random, returnMap);
		JSONObject result = JSONObject.fromObject(returnMap);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/isFinishSaveImport")
	public String isFinishSaveImport(Long random) {
		JSONObject result = new JSONObject();
		Map<String, Object> map = fileRandom.get(random);
		if (map != null) {
			String importThreadName = map.get("threadName").toString();
			String fileName = map.get("fileName").toString();
			result.put("fileName", fileName);
			if (ImportUserCertOfflineThread.isOver.containsKey(importThreadName)) {
				result.put("finish", false);
			} else {
				result.put("finish", true);
			}
			result.put("sucessImportNum", 0);
			result.put("unSucessImportNum", 0);
			if (ImportUserCertOfflineThread.map.get(importThreadName) != null) {
				long sucessImportNum = ImportUserCertOfflineThread.map.get(importThreadName).get(0);
				long unSucessImportNum = ImportUserCertOfflineThread.map.get(importThreadName).get(1);
				result.put("sucessImportNum", sucessImportNum);
				result.put("unSucessImportNum", unSucessImportNum);
			}
		} else {
			result.put("finish", true);
		}
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/list")
	public Object usercertList(String idcard, String name, String mobilePhone, String unit) {
		if (StringUtils.isBlank(idcard) && StringUtils.isBlank(name) && StringUtils.isBlank(mobilePhone) && StringUtils.isBlank(unit)) {
			JSONArray result = new JSONArray();
			return "successCallback(" + result.toString() + ")";
		}
		List<UserCertOfflineDTO> usercerts = userCertOfflineManager.getUserCerts(idcard, name, unit, mobilePhone);
		JSONArray result = JSONArray.fromObject(usercerts);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/saveUserCert")
	public Object save(String userId, String certId, String jsonData) {
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isBlank(userId)) {
			map.put("status", "0");
			map.put("msg", "生成证书失败，用户id不能为空");
			return map;
		}
		if (StringUtils.isBlank(certId)) {
			map.put("status", "0");
			map.put("msg", "生成证书失败，证书id不能为空");
			return map;
		}
		try {
			map = userCertOfflineManager.saveUserCert(userId, Long.valueOf(certId), jsonData);
		} catch (Exception e) {
			map.put("status", "0");
			map.put("msg", "生成证书失败，" + e.getMessage());
			return map;
		}
		return map;
	}

}
