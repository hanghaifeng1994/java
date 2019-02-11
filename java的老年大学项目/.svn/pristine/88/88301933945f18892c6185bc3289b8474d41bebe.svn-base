package cn.com.weyeyun.commoncert.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import cn.com.weyeyun.commoncert.constains.Constants;
import cn.com.weyeyun.commoncert.dto.UserCertOfflineDTO;
import cn.com.weyeyun.commoncert.model.Cert;
import cn.com.weyeyun.commoncert.model.UserCertOffline;
import cn.com.weyeyun.commoncert.service.CertService;
import cn.com.weyeyun.commoncert.service.UserCertOfflineService;
import cn.com.weyeyun.commoncert.util.BeanUtil;
import cn.com.weyeyun.commoncert.util.ImportUserCertOfflineThread;
import cn.com.weyeyun.commoncert.util.StringUtil;
import cn.com.weyeyun.commoncert.vo.CertplateVO;
import cn.common.lib.springside.orm.ExtPropertyFilter;
import cn.common.lib.springside.orm.page.ExtPage;
import cn.common.lib.util.web.PropertyUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

@Component
@Transactional
public class UserCertOfflineManager {
	@Autowired
	private UserCertOfflineService userCertOfflineService;
	@Autowired
	private CertManager certManager;
	@Autowired
	private CertService certService;

	/*
	 * @Autowired private UserCertService userCertService;
	 */

	// DTO转换为对象
	public UserCertOffline convertDTOToEntity(UserCertOfflineDTO userCertOfflineDTO) {
		UserCertOffline userCertOffline = null;
		if (userCertOfflineDTO.getId() == null)
			userCertOffline = new UserCertOffline();
		else
			userCertOffline = userCertOfflineService.get(userCertOfflineDTO.getId());
		BeanUtil.copyProperties(userCertOffline, userCertOfflineDTO);
		return userCertOffline;
	}

	/**
	 * //对象转换为DTO
	 * 
	 * @author sli
	 * @param userCertOffline
	 * @return
	 */
	public UserCertOfflineDTO convertEntityToDTO(UserCertOffline userCertOffline) {
		UserCertOfflineDTO userCertOfflineDTO = new UserCertOfflineDTO();
		BeanUtil.copyProperties(userCertOfflineDTO, userCertOffline);
		if (userCertOffline.getCert() != null)
			userCertOfflineDTO.setCert(certManager.convertEntityToDTO(userCertOffline.getCert()));
		return userCertOfflineDTO;
	}

	// 对象list转换为DTO
	public List<UserCertOfflineDTO> convertListToDTO(List<UserCertOffline> userCerts) {
		List<UserCertOfflineDTO> userCertDTOs = Lists.newArrayList();
		for (UserCertOffline userCertOffline : userCerts) {
			userCertDTOs.add(convertEntityToDTO(userCertOffline));
		}
		return userCertDTOs;
	}

	// 分页数据转换
	@SuppressWarnings({ "unchecked" })
	public Page convertPageToDTO(Page desc, Page orig) {
		if (orig == null) {
			return null;
		}
		try {
			// desc = orig;
			BeanUtil.copyProperties(desc, orig);
			List list = orig.getResult();
			List listDTO = new ArrayList();
			listDTO = convertListToDTO(list);
			desc.setResult(listDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;
	}

	/**
	 * pageDTO转换为page
	 * 
	 * @param page
	 * @return
	 */
	public Page<UserCertOffline> convertDTOToPage(Page<UserCertOfflineDTO> page) {
		Page<UserCertOffline> page2 = new ExtPage<UserCertOffline>(page.getPageSize());
		page2.setPageNo(page.getPageNo());
		if (page.getOrder() != null)
			page2.setOrder(page.getOrder());
		if (page.getOrderBy() != null)
			page2.setOrderBy(page.getOrderBy());
		return page2;
	}

	/**
	 * 获得对象dto
	 * 
	 * @author hli
	 * @param id
	 * @return
	 */
	public UserCertOfflineDTO get(String id) {
		return convertEntityToDTO(userCertOfflineService.get(id));
	}

	/**
	 * 保存
	 * 
	 * @author hli
	 */
	public void save(UserCertOfflineDTO userCertOfflineDTO) {
		userCertOfflineService.save(convertDTOToEntity(userCertOfflineDTO));
	}

	/**
	 * 删除
	 * 
	 * @author hli
	 */
	public void delete(Long id) {
		userCertOfflineService.delete(id);
	}

	/**
	 * @author zhaowei
	 * @param page
	 * @param filters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<UserCertOfflineDTO> extSearch(final Page<UserCertOfflineDTO> page, List<ExtPropertyFilter> filters) {
		return convertPageToDTO(page, userCertOfflineService.extSearch(convertDTOToPage(page), filters));
	}

	/**
	 * 根据用户id获取list
	 * 
	 * @author hli
	 * @param userId
	 * @return
	 */
	public List<UserCertOfflineDTO> getByUser(Long userId) {
		return convertListToDTO(userCertOfflineService.getByUser(userId));
	}

	public List<UserCertOfflineDTO> getUserCertsByIds(List<Long> ids) {
		return convertListToDTO(userCertOfflineService.getUserCertsByIds(ids));
	}

	public List<UserCertOfflineDTO> getUserCerts(String idcard, String name, String unit, String mobilePhone) {
		return convertListToDTO(userCertOfflineService.getUserCerts(null, idcard, unit, name, mobilePhone, true));
	}

	public File exportUserCertToPdf(List<ExtPropertyFilter> filters, String outPdfPath) {
		String photoPath = PropertyUtils.getProperty("traincore.uploadpath");
		List<UserCertOffline> userCerts = userCertOfflineService.extFind(filters);
		try {
			// Document doc = new Document(PageSize.A4, 0, 0, 0, 0);
			Document doc = new Document(new Rectangle(PageSize.A4.height(), PageSize.A4.width()), 0, 0, 0, 0);

			// Document doc = new Document(new Rectangle(595 + 17, 842 + 17), 0,
			// 0, 0, 0);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(photoPath + outPdfPath));
			doc.open();
			for (UserCertOffline userCertOffline : userCerts) {
				doc.newPage();// 新的pdf页
				String path = getUserCertPathByCatch(userCertOffline);
				createPdfPage(path, doc);
			}
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File mOutputPdfFile = new File(photoPath + outPdfPath);
		if (!mOutputPdfFile.exists()) {
			mOutputPdfFile.deleteOnExit();
			return null;
		}
		return mOutputPdfFile;

	}

	public File exportUserCertToPdf(String usercertids, String outPdfPath) {
		String photoPath = PropertyUtils.getProperty("traincore.uploadpath");
		try {
			Document doc = new Document(new Rectangle(PageSize.A4.height(), PageSize.A4.width()), 0, 0, 0, 0);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(photoPath + outPdfPath));
			doc.open();
			for (String id : usercertids.split(",")) {
				UserCertOffline userCertOffline = userCertOfflineService.get(id);
				String path = getUserCertPathByCatch(userCertOffline);
				doc.newPage();// 新的pdf页
				createPdfPage(path, doc);
			}
			writer.close();
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File mOutputPdfFile = new File(photoPath + outPdfPath);
		if (!mOutputPdfFile.exists()) {
			mOutputPdfFile.deleteOnExit();
			return null;
		}
		return mOutputPdfFile;

	}

	/**
	 * 套打证书
	 * 
	 * @param filters
	 * @param outPdfPath
	 * @return
	 */
	public File exportTdUserCertToPdf(List<ExtPropertyFilter> filters, String outPdfPath) {
		String photoPath = PropertyUtils.getProperty("traincore.uploadpath");
		List<UserCertOffline> userCerts = userCertOfflineService.extFind(filters);
		try {
			Document doc = new Document(new Rectangle(PageSize.A4.height(), PageSize.A4.width()), 0, 0, 0, 0);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(photoPath + outPdfPath));
			doc.open();
			for (UserCertOffline userCertOffline : userCerts) {
				doc.newPage();// 新的pdf页
				String path = getBlankUserCertPathByCatch(userCertOffline);
				createPdfPage(path, doc);
			}
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File mOutputPdfFile = new File(photoPath + outPdfPath);
		if (!mOutputPdfFile.exists()) {
			mOutputPdfFile.deleteOnExit();
			return null;
		}
		return mOutputPdfFile;

	}

	/**
	 * 套打证书
	 * 
	 * @param usercertids
	 * @param outPdfPath
	 * @return
	 */
	public File exportTdUserCertToPdf(String usercertids, String outPdfPath) {
		String photoPath = PropertyUtils.getProperty("traincore.uploadpath");
		try {
			Document doc = new Document(new Rectangle(PageSize.A4.height(), PageSize.A4.width()), 0, 0, 0, 0);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(photoPath + outPdfPath));
			doc.open();
			for (String id : usercertids.split(",")) {
				UserCertOffline userCertOffline = userCertOfflineService.get(id);
				String path = getBlankUserCertPathByCatch(userCertOffline);
				doc.newPage();// 新的pdf页
				createPdfPage(path, doc);
			}
			// writer.close();
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File mOutputPdfFile = new File(photoPath + outPdfPath);
		if (!mOutputPdfFile.exists()) {
			mOutputPdfFile.deleteOnExit();
			return null;
		}
		return mOutputPdfFile;

	}

	private void createPdfPage(String path, Document doc) throws MalformedURLException, IOException, DocumentException {
		Image backgroundImage = Image.getInstance(path);
		backgroundImage.setAlignment(Image.MIDDLE);
		backgroundImage.setAlignment(Image.TEXTWRAP);
		backgroundImage.scaleAbsolute(PageSize.A4.height(), PageSize.A4.width());
		doc.add(backgroundImage);
	}

	/**
	 * 发布证书
	 * 
	 * @author hli
	 * @param ids
	 */
	public void publish(Long[] ids) {
		userCertOfflineService.publish(ids);
	}

	/**
	 * 取消发布证书
	 * 
	 * @author hli
	 * @param ids
	 */
	public void unpublish(Long[] ids) {
		userCertOfflineService.unpublish(ids);
	}

	public void printed(Long[] ids) {
		userCertOfflineService.printed(ids);
	}

	public void unprinted(Long[] ids) {
		userCertOfflineService.unprinted(ids);
	}

	public long getUserCertCount(boolean published, Long tenantId, Long userId) {
		return userCertOfflineService.getUserCertCount(published, tenantId, userId);
	}

	public void batchPrintStatus(List<ExtPropertyFilter> filters, String usercertids, boolean printed) {
		if (StringUtils.isNotBlank(usercertids)) {
			userCertOfflineService.batchPrintStatus(usercertids, printed);
		} else {
			userCertOfflineService.batchPrintStatus(filters, printed);
		}
	}

	/**
	 * 证书批量预览和打印
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map<String, CertplateVO> singleViewPrint(Long id) throws Exception {
		return userCertOfflineService.singleViewPrint(id);
	}

	/**
	 * 重新生成证书
	 * 
	 * @param id
	 * @return
	 */
	public String getUserCertPath(Long id) {
		Map<String, CertplateVO> map = Maps.newHashMap();
		try {
			map = singleViewPrint(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CertplateVO certplateVO = map.get("vo");
		if (certplateVO != null) {
			return userCertOfflineService.getUserCertPath(id, certplateVO);
		}
		return "";
	}

	/**
	 * 已有图片的不再生成
	 * 
	 * @param id
	 * @return
	 */
	public String getUserCertPathByCatch(Long id) {
		UserCertOffline userCertOffline = userCertOfflineService.get(id);
		return getUserCertPathByCatch(userCertOffline);
	}

	/**
	 * 直接查找证书图片是否存在，存在不再重新生成
	 * 
	 * @param userCertOffline
	 * @return
	 */
	public String getUserCertPathByCatch(UserCertOffline userCertOffline) {
		String uploadPath = PropertyUtils.getProperty("traincore.uploadpath");
		String certImagePath01 = uploadPath + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + ".png";
		String certImagePath02 = uploadPath + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + ".jpg";
		File cert01 = new File(certImagePath01);
		File cert02 = new File(certImagePath02);
		if (cert01.exists()) {
			return certImagePath01;
		} else if (cert02.exists()) {
			return certImagePath02;
		} else {
			return getUserCertPath(userCertOffline.getId());
		}
	}

	public String getBlankUserCertPath(Long id) {
		Map<String, CertplateVO> map = Maps.newHashMap();
		try {
			map = singleViewPrint(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CertplateVO certplateVO = map.get("vo");
		if (certplateVO != null) {
			return userCertOfflineService.getBlankUserCertPath(id, certplateVO);
		}
		return "";
	}

	public String getBlankUserCertPathByCatch(Long id) {
		UserCertOffline userCertOffline = userCertOfflineService.get(id);
		return getBlankUserCertPathByCatch(userCertOffline);
	}

	public String getBlankUserCertPathByCatch(UserCertOffline userCertOffline) {
		String uploadPath = PropertyUtils.getProperty("traincore.uploadpath");
		String certImagePath01 = uploadPath + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + "_blank.png";
		String certImagePath02 = uploadPath + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + "_blank.jpg";
		File cert01 = new File(certImagePath01);
		File cert02 = new File(certImagePath02);
		if (cert01.exists()) {
			return certImagePath01;
		} else if (cert02.exists()) {
			return certImagePath02;
		} else {
			return getBlankUserCertPath(userCertOffline.getId());
		}
	}

	public String getUserCertUrl(Long id) {
		UserCertOffline userCertOffline = userCertOfflineService.get(id);
		String uploadPath = PropertyUtils.getProperty("traincore.uploadpath");
		String uploadUrl = PropertyUtils.getProperty("traincore.uploadpath.url", "");
		String certImagePath01 = uploadPath + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + ".png";
		String certImagePath02 = uploadPath + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + ".jpg";

		File cert01 = new File(certImagePath01);
		File cert02 = new File(certImagePath02);
		if (cert01.exists()) {
			return uploadUrl + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + ".png";
		} else if (cert02.exists()) {
			return uploadUrl + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + ".jpg";
		} else {
			String path = getUserCertPath(userCertOffline.getId());
			return uploadUrl + Constants.USERCERTPATH + "/" + userCertOffline.getCertno() + "." + path.substring(path.lastIndexOf(".") + 1);
		}
	}

	public List<List<Object>> saveImportOfflineCert(List<Map<String, String>> datas, String threadName, List<List<Object>> result, Long certId, int importType, String tenantId) {
		List<Object> objlist;
		List<Long> importNum = ImportUserCertOfflineThread.map.get(threadName);
		long sucessImportNum = 0;
		long unSucessImportNum = 0;
		if (importNum == null) {
			importNum = Lists.newArrayList();
		} else {
			sucessImportNum = importNum.get(0);
			unSucessImportNum = importNum.get(1);
		}
		Cert cert = certService.get(certId);
		for (int i = 0; i < datas.size(); i++) {
			String certno = datas.get(i).get("证书编号");
			String unit = datas.get(i).get("工作单位");
			String name = datas.get(i).get("姓名");
			String mobilePhone = datas.get(i).get("手机号码");
			String idcard = datas.get(i).get("身份证号码");
			String program = datas.get(i).get("培训科目");
			String score = datas.get(i).get("学分");
			String phase = datas.get(i).get("培训年度");
			String year = datas.get(i).get("年");
			String month = datas.get(i).get("月");
			String day = datas.get(i).get("日");

			String col01 = datas.get(i).get("第一列");
			String col02 = datas.get(i).get("第二列");
			String col03 = datas.get(i).get("第三列");
			String col04 = datas.get(i).get("第四列");
			String col05 = datas.get(i).get("第五列");
			String col06 = datas.get(i).get("第六列");
			String col07 = datas.get(i).get("第七列");
			String col08 = datas.get(i).get("第八列");
			String col09 = datas.get(i).get("第九列");
			String col10 = datas.get(i).get("第十列");

			if (StringUtils.isBlank(unit) && StringUtils.isBlank(name) && StringUtils.isBlank(mobilePhone) && StringUtils.isBlank(idcard) && StringUtils.isBlank(program) && StringUtils.isBlank(score)
					&& StringUtils.isBlank(phase) && StringUtils.isBlank(year) && StringUtils.isBlank(month) && StringUtils.isBlank(day)) {
				continue;
			}

			/*
			 * if (StringUtils.isBlank(certno)) { Long errorline = i + 2L;
			 * objlist = Lists.newArrayList(); objlist.add(errorline);
			 * objlist.add(""); objlist.add("证书编号为空！"); result.add(objlist);
			 * unSucessImportNum += 1; importNum = Lists.newArrayList();
			 * importNum.add(0, sucessImportNum); importNum.add(1,
			 * unSucessImportNum);
			 * ImportUserCertOfflineThread.map.put(threadName, importNum);
			 * continue; }
			 */

			if (StringUtils.isNotBlank(mobilePhone)) {
				if (!StringUtil.isPhone(mobilePhone)) {
					Long errorline = i + 2L;
					objlist = Lists.newArrayList();
					objlist.add(errorline);
					objlist.add(mobilePhone);
					objlist.add("手机号码错误！");
					result.add(objlist);
					unSucessImportNum += 1;
					importNum = Lists.newArrayList();
					importNum.add(0, sucessImportNum);
					importNum.add(1, unSucessImportNum);
					ImportUserCertOfflineThread.map.put(threadName, importNum);
					continue;
				}
			}

			if (importType == 1) {
				UserCertOffline userCertOffline = userCertOfflineService.getUserCertOne(cert.getId(), certno);
				if (userCertOffline == null) {
					userCertOffline = new UserCertOffline();
					userCertOffline.setGenTime(new Date());
				}
				userCertOffline.setCertno(certno);
				userCertOffline.setIdcard(idcard);
				userCertOffline.setUsername(idcard);
				userCertOffline.setUnit(unit);
				userCertOffline.setName(name);
				userCertOffline.setMobilePhone(mobilePhone);
				userCertOffline.setProgram(program);
				userCertOffline.setScore(score);
				userCertOffline.setPhase(phase);
				userCertOffline.setYear(year);
				userCertOffline.setMonth(month);
				userCertOffline.setDay(day);
				userCertOffline.setCert(cert);
				userCertOffline.setCol01(col01);
				userCertOffline.setCol02(col02);
				userCertOffline.setCol03(col03);
				userCertOffline.setCol04(col04);
				userCertOffline.setCol05(col05);
				userCertOffline.setCol06(col06);
				userCertOffline.setCol07(col07);
				userCertOffline.setCol08(col08);
				userCertOffline.setCol09(col09);
				userCertOffline.setCol10(col10);
				userCertOffline.setTenantId(tenantId);
				userCertOffline.setPublished(true);
				userCertOfflineService.save(userCertOffline);
			}
			sucessImportNum += 1;
			importNum.add(0, sucessImportNum);
			importNum.add(1, unSucessImportNum);
			ImportUserCertOfflineThread.map.put(threadName, importNum);
		}

		return result;
	}

	@Transactional
	public Map<String, String> saveUserCert(String userId, Long certId, String jsonData) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(jsonData);
		JSONObject param = JSONObject.fromObject(jsonData);
		Cert cert = certService.get(certId);
		UserCertOffline userCertOffline = userCertOfflineService.getUserCertOfflineByUserIdAndCert(userId, certId);
		if (userCertOffline == null) {
			userCertOffline = new UserCertOffline();
			userCertOffline.setGenTime(new Date());
		}
		userCertOffline.setUserId(userId);
		userCertOffline.setCertno(generateSn(cert));
		userCertOffline.setIdcard(param.get("idcard")==null?"":param.getString("idcard"));
		userCertOffline.setUsername(param.get("idcard")==null?"":param.getString("idcard"));
		userCertOffline.setUnit(param.get("unit")==null?"":param.getString("unit"));
		userCertOffline.setName(param.get("name")==null?"":param.getString("name"));
		userCertOffline.setMobilePhone(param.get("mobilePhone")==null?"":param.getString("mobilePhone"));
		userCertOffline.setProgram(param.get("program")==null?"":param.getString("program"));
		userCertOffline.setScore(param.get("score")==null?"":param.getString("score"));
		userCertOffline.setPhase(param.get("phase")==null?"":param.getString("phase"));
		userCertOffline.setYear(param.get("year")==null?"":param.getString("year"));
		userCertOffline.setMonth(param.get("month")==null?"":param.getString("month"));
		userCertOffline.setDay(param.get("day")==null?"":param.getString("day"));
		userCertOffline.setCert(cert);
		userCertOffline.setCol01(param.get("col01")==null?"":param.getString("col01"));
		userCertOffline.setCol02(param.get("col02")==null?"":param.getString("col02"));
		userCertOffline.setCol03(param.get("col03")==null?"":param.getString("col03"));
		userCertOffline.setCol04(param.get("col04")==null?"":param.getString("col04"));
		userCertOffline.setCol05(param.get("col05")==null?"":param.getString("col05"));
		userCertOffline.setCol06(param.get("col06")==null?"":param.getString("col06"));
		userCertOffline.setCol07(param.get("col07")==null?"":param.getString("col07"));
		userCertOffline.setCol08(param.get("col08")==null?"":param.getString("col08"));
		userCertOffline.setCol09(param.get("col09")==null?"":param.getString("col09"));
		userCertOffline.setCol10(param.get("col10")==null?"":param.getString("col10"));
		userCertOffline.setTenantId(param.get("siteId")==null?"":param.getString("siteId"));
		userCertOffline.setPublished(true);
		userCertOfflineService.save(userCertOffline);

		map.put("status", "1");
		map.put("msg", "生成证书成功.");
		map.put("id", userCertOffline.getId().toString());
		return map;
	}
	
	/**
	 * 生成证书编号
	 * 
	 * @param year
	 * @return
	 */
	private String generateSn(Cert cert) {
		long serialNum = this.getNexSerialNum(cert);
		String serial = format(serialNum, 6);
		String certNo = cert.getCode();
		certNo = certNo + DateUtil.formatDate(new Date(), "yyyy") + serial;
		return certNo;
	}
	
	private long getNexSerialNum(Cert cert) {
		cert.setSerialNum(cert.getSerialNum() + 1);
		return cert.getSerialNum();
	}
	
	public String format(long i, int bits) {
		double num = Math.pow(10, bits);
		num = num + i;
		return String.valueOf((int) num).substring(1);
	}
}
