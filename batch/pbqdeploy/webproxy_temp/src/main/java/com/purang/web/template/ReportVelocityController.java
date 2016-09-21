package com.purang.web.template;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.purang.web.filter.PriceAndReportDataFilter;
import com.purang.web.util.ConfigManager;
import com.purang.web.util.SessionUtils;

import net.sf.json.JSONArray;

@Controller
public class ReportVelocityController extends TemplateController {
	private static final Logger logger = Logger.getLogger(ReportVelocityController.class);

	@RequestMapping(value = "/reportview.htm")
	public ModelAndView reportView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			SessionUtils sessionUtils = new SessionUtils();
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			String report = new String((StringUtils.defaultIfEmpty(request.getParameter("report"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String queryString = new String((StringUtils.defaultIfEmpty(request.getQueryString(), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("report", report);
			mv.addObject("queryString", queryString);
			mv.addObject("permissionHelper", permissionHelper);
			mv.addObject("sessionUtils", sessionUtils);
			mv.addObject("userType", session.get("userType"));
			mv.addObject("info", session.get("info"));
			mv.addObject("enterpriseId", session.get("enterpriseId"));
			mv.addObject("employeeNo", session.get("employeeNo"));
			if (session.get("orgs") != null && !"".equals(session.get("orgs"))) {
				mv.addObject("orgs", JSONArray.fromObject(session.get("orgs")));
			}

			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/reportview");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/reportview-bba.htm")
	public ModelAndView reportViewBBA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			SessionUtils sessionUtils = new SessionUtils();
			String report = new String((StringUtils.defaultIfEmpty(request.getParameter("report"), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("report", report);
			mv.addObject("sessionUtils", sessionUtils);
			mv.addObject("permissionHelper", permissionHelper);
			mv.addObject("userType", session.get("userType"));
			mv.addObject("enterpriseId", session.get("enterpriseId"));
			mv.addObject("employeeNo", session.get("employeeNo"));
			if (session.get("orgs") != null && !"".equals(session.get("orgs"))) {
				mv.addObject("orgs", JSONArray.fromObject(session.get("orgs")));
			}
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/reportview-bba");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/reportview-crm.htm")
	public ModelAndView reportViewCRM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			String report = new String((StringUtils.defaultIfEmpty(request.getParameter("report"), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("report", report);
			mv.addObject("permissionHelper", permissionHelper);
			mv.addObject("employeeNo", session.get("employeeNo"));
			if (session.get("orgs") != null && !"".equals(session.get("orgs"))) {
				mv.addObject("orgs", JSONArray.fromObject(session.get("orgs")));
			}
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/reportview-crm");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-价格建议统计表
	@RequestMapping(value = "/eba_priceadvice.htm")
	public ModelAndView ebaPriceSuggestReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_priceadvice");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-价格发布统计表
	@RequestMapping(value = "/eba_pricepublish.htm")
	public ModelAndView ebaPricePublishReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricepublish");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-价格发布统计表
	@RequestMapping(value = "/eba_pricereference.htm")
	public ModelAndView ebaPriceReferenceReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricereference");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-当日价格运营检查表（利率）
	@RequestMapping(value = "/eba_pricemotion_check_rate.htm")
	public ModelAndView ebaPriceMotionCheckRateReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricemotion_check_rate");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-当日价格运营检查表（笔数 ）
	@RequestMapping(value = "/eba_pricemotion_check_number.htm")
	public ModelAndView ebaPriceMotionCheckNumberReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricemotion_check_number");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-当日价格运营检查表（业务量 ）
	@RequestMapping(value = "/eba_pricemotion_check_business.htm")
	public ModelAndView ebaPriceMotionCheckBusinessReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricemotion_check_business");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-价格采集表（办事处）
	@RequestMapping(value = "/eba_pricecollect_dept.htm")
	public ModelAndView ebaPriceCollectDeptReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricecollect_dept");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 直贴-价格采集表（日期）
	@RequestMapping(value = "/eba_pricecollect.htm")
	public ModelAndView ebaPriceCollectReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/eba/eba_pricecollect");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DeclarTrade_Grade_Daypj_je.htm")
	public ModelAndView bbaReportyDayJeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String timespan = new String((StringUtils.defaultIfEmpty(request.getParameter("timespan"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("timespan", timespan);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DeclarTrade_Grade_Daypj_je");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DeclarTrade_Grade_Daypj_bs.htm")
	public ModelAndView bbaReportyDayBsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String timespan = new String((StringUtils.defaultIfEmpty(request.getParameter("timespan"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("timespan", timespan);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DeclarTrade_Grade_Daypj_bs");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DeclarTrade_Grade_Daybq_je.htm")
	public ModelAndView bbaReportyDayBqJeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String timespan = new String((StringUtils.defaultIfEmpty(request.getParameter("timespan"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("timespan", timespan);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DeclarTrade_Grade_Daybq_je");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DeclarTrade_Grade_Daybq_bs.htm")
	public ModelAndView bbaReportyDayBqBsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String timespan = new String((StringUtils.defaultIfEmpty(request.getParameter("timespan"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("timespan", timespan);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DeclarTrade_Grade_Daybq_bs");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Rate_Estimate.htm")
	public ModelAndView ebaRateEstimateReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String(StringUtils.defaultIfEmpty(request.getParameter("rttype"), "").getBytes("ISO-8859-1"), "UTF-8");
			String type = new String(StringUtils.defaultIfEmpty(request.getParameter("type"), "").getBytes("ISO-8859-1"), "UTF-8");
			String billmedia = new String(StringUtils.defaultIfEmpty(request.getParameter("billmedia"), "").getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("type", type);
			mv.addObject("billmedia", billmedia);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Rate_Estimate");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DeclareTrade_Check.htm")
	public ModelAndView ebaDeclareTradeCheckReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DeclareTrade_Check");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DayManage_Dynamic.htm")
	public ModelAndView ebaDayManageDynamicReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DayManage_Dynamic");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_BillTrade_Statistical.htm")
	public ModelAndView ebaBillTradeStatisticalReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_BillTrade_Statistical");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_DayInventory.htm")
	public ModelAndView ebaDayInventoryReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String(StringUtils.defaultIfEmpty(request.getParameter("rttype"), "").getBytes("ISO-8859-1"), "UTF-8");
			String billtype = new String(StringUtils.defaultIfEmpty(request.getParameter("billtype"), "").getBytes("ISO-8859-1"), "UTF-8");
			String billmedia = new String(StringUtils.defaultIfEmpty(request.getParameter("billmedia"), "").getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("billtype", billtype);
			mv.addObject("billmedia", billmedia);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DayInventory");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Peripheral_Bank.htm")
	public ModelAndView ebaPeripheralBankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Peripheral_Bank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Inventory_Classify.htm")
	public ModelAndView ebaInventory_ClassifyReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Inventory_Classify");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Rateoperate_Check.htm")
	public ModelAndView ebaRateoperateCheckReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String billmedia = new String(StringUtils.defaultIfEmpty(request.getParameter("billmedia"), "").getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("billmedia", billmedia);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Rateoperate_Check");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Accumulated_Occure.htm")
	public ModelAndView ebaAccumulatedOccureReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String rttype = new String(StringUtils.defaultIfEmpty(request.getParameter("rttype"), "").getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("rttype", rttype);
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Accumulated_Occure");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Bank_Attendance_Rate.htm")
	public ModelAndView ebaBankAttendanceRateReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Bank_Attendance_Rate");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Plan_Completion_Check.htm")
	public ModelAndView ebaPlanCompletionCheckReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Plan_Completion_Check");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Manage_Business_Stat.htm")
	public ModelAndView ebaManageBusinessStatReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Manage_Business_Stat");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Detail_Rank.htm")
	public ModelAndView ebaDetailRankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Detail_Rank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Completion_Rank.htm")
	public ModelAndView ebaCompletionRankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Completion_Rank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Income_Percent_All.htm")
	public ModelAndView ebaIncomePercentAllReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Income_Percent_All");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Busi_Expected_Compleat.htm")
	public ModelAndView ebaBusiExpectedCompleatReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Busi_Expected_Compleat");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Rate_Estimate_Planchange_Dept.htm")
	public ModelAndView ebaRateEstimatePlanchangeDeptReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Rate_Estimate_Planchange_Dept");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Rate_Estimate_BusiEarnchange.htm")
	public ModelAndView ebaRateEstimateBusiEarnchangeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Rate_Estimate_BusiEarnchange");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Intention_Change.htm")
	public ModelAndView ebaIntention_ChangeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Intention_Change");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BillManage_1.htm")
	public ModelAndView ebaMonthCheck_BillManage_1Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_MonthCheck_BillManage_1");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BillManage_2.htm")
	public ModelAndView ebaMonthCheck_BillManage_2Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_MonthCheck_BillManage_2");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BillManage_3.htm")
	public ModelAndView ebaMonthCheck_BillManage_3Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Eba_MonthCheck_BillManage_3");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BillManage_4.htm")
	public ModelAndView ebaMonthCheck_BillManage_4Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Eba_MonthCheck_BillManage_4");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BillManage_5.htm")
	public ModelAndView ebaMonthCheck_BillManage_5Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Eba_MonthCheck_BillManage_5");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BillManage_6.htm")
	public ModelAndView ebaMonthCheck_BillManage_6Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Eba_MonthCheck_BillManage_6");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Night_Duty_1.htm")
	public ModelAndView eba_Night_Duty_1Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Night_Duty_1");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Night_Duty_2.htm")
	public ModelAndView eba_Night_Duty_2Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Night_Duty_2");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Night_Duty_3.htm")
	public ModelAndView eba_Night_Duty_3Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Night_Duty_3");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 分公司业务统计
	@RequestMapping(value = "/Eba_Branch_Business_Statistics.htm")
	public ModelAndView ebaBranchBusinessStatisticsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Branch_Business_Statistics");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 分公司创收统计表
	@RequestMapping(value = "/Eba_Branch_Income_Statistics.htm")
	public ModelAndView ebaBranchIncomeStatisticsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Branch_Income_Statistics");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_DeclareTrade_Check.htm")
	public ModelAndView bbaDeclareTradeCheckReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_DeclareTrade_Check");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_BillTrade_Statistical.htm")
	public ModelAndView bbaBillTradeStatisticalReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_BillTrade_Statistical");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_DayManage_Dynamic.htm")
	public ModelAndView bbaDayManageDynamicReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_DayManage_Dynamic");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_BillTrade_Statistical_Manager.htm")
	public ModelAndView bbaBillTradeStatisticalManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_BillTrade_Statistical_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_Plan_Completion_Check_All.htm")
	public ModelAndView bbaPlanCompletionCheckAllReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_Plan_Completion_Check_All");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_Plan_Completion_Check.htm")
	public ModelAndView bbaPlanCompletionCheckReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_Plan_Completion_Check");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_DayManage_Busi_Bank.htm")
	public ModelAndView bbaDayManage_Busi_BankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_DayManage_Busi_Bank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_Detail_Rank.htm")
	public ModelAndView bbaDetailRankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_Detail_Rank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_Completion_Rank.htm")
	public ModelAndView bbaCompletionRankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_Completion_Rank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_Plan_Completion_Check_Manager.htm")
	public ModelAndView bbaPlanCompletionCheckManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_Plan_Completion_Check_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bba_Income_Percent_All.htm")
	public ModelAndView bbaIncomePercentAllReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bba_new/Bba_Income_Percent_All");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// CRM-客户数量运营检查表 （部门）
	@RequestMapping(value = "/crm_customoperationcheck_dept.htm")
	public ModelAndView ebaCrmCustomOperationCheckReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/crm_customoperationcheck_dept");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// CRM-客户数量运营检查表 （行业）
	@RequestMapping(value = "/crm_customoperationcheck_industry.htm")
	public ModelAndView ebaCrmCustomOperationCheckIndustryReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/crm_customoperationcheck_industry");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// CRM-客户新申报审核检查表 （部门）
	@RequestMapping(value = "/crm_customappreviewck.htm")
	public ModelAndView ebaCrmCustomAppReviewCKReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/crm_customappreviewck");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// CRM-客户新申报审核检查表 （行业）
	@RequestMapping(value = "/crm_customappreview_ind.htm")
	public ModelAndView ebaCrmCustomAppReviewIndReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/crm_customappreview_ind");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_CustomNum.htm")
	public ModelAndView crmCustomNumReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("rttype", rttype);
			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_CustomNum");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_CustomTrade.htm")
	public ModelAndView crmCustomTradeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("rttype", rttype);
			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_CustomTrade");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_CustomAudit.htm")
	public ModelAndView crmCustomAuditReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String rttype = new String((StringUtils.defaultIfEmpty(request.getParameter("rttype"), "")).getBytes("ISO-8859-1"), "UTF-8");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("rttype", rttype);
			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_CustomAudit");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_CustomSleep.htm")
	public ModelAndView crmCustomSleepReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_CustomSleep");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_BelongCustom_Plan.htm")
	public ModelAndView crmBelongCustomPlanReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_BelongCustom_Plan");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_BelongCustom_Census.htm")
	public ModelAndView crmBelongCustomCensusReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_BelongCustom_Census");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Accumulate_Points.htm")
	public ModelAndView crmAccumulatePointsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Accumulate_Points");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_CustomNum_Manager.htm")
	public ModelAndView crmCustomNumManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_CustomNum_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Operating_State_Num.htm")
	public ModelAndView crmOperatingStateNumReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Operating_State_Num");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_TradeAmount_Bank.htm")
	public ModelAndView crmTradeAmountBankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_TradeAmount_Bank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_TradeAmount_Org_Bond.htm")
	public ModelAndView crmTradeAmountOrgBondReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_TradeAmount_Org_Bond");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_TradeAmount_Org_Fund.htm")
	public ModelAndView crmTradeAmountOrgFundReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_TradeAmount_Org_Fund");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_TradeAmount_Rank_Bond.htm")
	public ModelAndView crmTradeAmountRankBondReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_TradeAmount_Rank_Bond");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_TradeAmount_Rank_Fund.htm")
	public ModelAndView crmTradeAmountRankFundReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_TradeAmount_Rank_Fund");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_TradeAmount_Rank.htm")
	public ModelAndView crmTradeAmountRankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_TradeAmount_Rank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Login_Enter_StateCheck_Com.htm")
	public ModelAndView crmLogin_Enter_StateCheck_ComReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Login_Enter_StateCheck_Com");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Login_Enter_StateCheck_Org1.htm")
	public ModelAndView crmLogin_Enter_StateCheck_Org1Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Login_Enter_StateCheck_Org1");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Login_Enter_StateCheck_Org2.htm")
	public ModelAndView crmLogin_Enter_StateCheck_Org2Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Login_Enter_StateCheck_Org2");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Login_Enter_StateCheck_Org3.htm")
	public ModelAndView crmLogin_Enter_StateCheck_Org3Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Login_Enter_StateCheck_Org3");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Enter_StateCheck_Com.htm")
	public ModelAndView crmEnter_StateCheck_ComReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Enter_StateCheck_Com");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Enter_StateCheck_Org.htm")
	public ModelAndView crmEnter_StateCheck_OrgReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Enter_StateCheck_Org");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_MonthCheck_ComLogin.htm")
	public ModelAndView crmMonthCheck_ComLoginReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_MonthCheck_ComLogin");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_MonthCheck_OrgLogin.htm")
	public ModelAndView crmMonthCheck_OrgLoginReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_MonthCheck_OrgLogin");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Operating_State_Company.htm")
	public ModelAndView crm_Operating_State_CompanyReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Operating_State_Company");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Crm_Platform_Registration_Statistics.htm")
	public ModelAndView crm_Platform_Registration_StatisticsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Crm_Platform_Registration_Statistics");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	// 客户数据统计表报表
	@RequestMapping(value = "/Crm_Branch_Customer_Statistics.htm")
	public ModelAndView crm_Branch_Customer_StatisticsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/crm_Branch_Customer_Statistics");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_EbaCustomer.htm")
	public ModelAndView crmEba_MonthCheck_EbaCustomerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Eba_MonthCheck_EbaCustomer");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_MonthCheck_BbaBank.htm")
	public ModelAndView crmEba_MonthCheck_BbaBankReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			String excelname = new String((StringUtils.defaultIfEmpty(request.getParameter("excelname"), "")).getBytes("ISO-8859-1"), "UTF-8");

			mv.addObject("excelname", excelname);
			mv.addObject("reportPath", reportPath);
			mv.setViewName("report/crm/Eba_MonthCheck_BbaBank");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_DeclareTrade.htm")
	public ModelAndView bondDeclareTradeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_DeclareTrade");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_TradeAmount.htm")
	public ModelAndView bondTradeAmountReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_TradeAmount");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Plan_Completiont.htm")
	public ModelAndView bondPlanCompletiontReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Plan_Completiont");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Plan_Completiont_Manager.htm")
	public ModelAndView bondPlanCompletiontManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Plan_Completiont_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Completion_Rate_Rank2.htm")
	public ModelAndView bondCompletionRateRank2Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Completion_Rate_Rank2");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Completion_Rate_Rank2_Dept.htm")
	public ModelAndView bondCompletionRateRank2DeptReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Completion_Rate_Rank2_Dept");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Plan_Compleation_Rank_Manager.htm")
	public ModelAndView bondPlanCompleationRankManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Plan_Compleation_Rank_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Plan_Compleation_Rank_Tai.htm")
	public ModelAndView bondPlanCompleationRankTaiReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Plan_Compleation_Rank_Tai");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Asset_Balance_Sheet.htm")
	public ModelAndView bondAssetBalanceSheetReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Asset_Balance_Sheet");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Budget_Profit_Loss.htm")
	public ModelAndView bondBudgetProfitLossReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Budget_Profit_Loss");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Product_Type_List.htm")
	public ModelAndView bondProductTypeListReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Product_Type_List");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Profit_Budget.htm")
	public ModelAndView bond_Profit_BudgetReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Profit_Budget");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Profit_Trend_Tracking.htm")
	public ModelAndView Bond_Profit_Trend_TrackingReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/bond_new/Bond_Profit_Trend_Tracking");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_DeclareTrade.htm")
	public ModelAndView FundDeclareTradeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_DeclareTrade");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_TradeAmount.htm")
	public ModelAndView FundTradeAmountReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_TradeAmount");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_Plan_Completiont.htm")
	public ModelAndView FundPlanCompletiontReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_Plan_Completiont");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_Plan_Completiont_Manager.htm")
	public ModelAndView FundPlanCompletiontManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_Plan_Completiont_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_Completion_Rate_Rank2.htm")
	public ModelAndView FundCompletionRateRank2Report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_Completion_Rate_Rank2");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_Completion_Rate_Rank2_Dept.htm")
	public ModelAndView FundCompletionRateRank2DeptReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_Completion_Rate_Rank2_Dept");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_Plan_Compleation_Rank_Manager.htm")
	public ModelAndView FundPlanCompleationRankManagerReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_Plan_Compleation_Rank_Manager");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Fund_Plan_Compleation_Rank_Tai.htm")
	public ModelAndView FundPlanCompleationRankTaiReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/fund_new/Fund_Plan_Compleation_Rank_Tai");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Interbank_Deposits.htm")
	public ModelAndView BondInterbankDepositsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/deposit/Bond_Interbank_Deposits");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Business_Assets.htm")
	public ModelAndView BondBusinessAssetsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/asset/Bond_Business_Assets");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Bond_Trade_Finance.htm")
	public ModelAndView BondTradeFinanceReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/finance/Bond_Trade_Finance");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	@RequestMapping(value = "/Eba_Bank_Business_Statistics.htm")
	public ModelAndView ebaLocatedBank_Business(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_Bank_Business_Statistics");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	
	@RequestMapping(value = "/ChartReport_Dynamic_KPI.htm")
	public ModelAndView chartReport_Dynamic_KPI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/newchart2016/ChartReport_Dynamic_KPI");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

	
	@RequestMapping(value = "/Eba_DayCheck_BillManage_BaoLi.htm")
	public ModelAndView ebaBillManageBaoLi(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DayCheck_BillManage_BaoLi");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}
	
	@RequestMapping(value = "/Eba_DayCheck_BillManage.htm")
	public ModelAndView ebaBillManage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			Map<String, String> session = (Map<String, String>) request.getSession().getAttribute("session");
			final Map<String, String> permissions = (Map<String, String>) request.getSession().getAttribute("permission");
			PriceAndReportDataFilter permissionHelper = new PriceAndReportDataFilter(permissions);
			mv.addObject("permissionHelper", permissionHelper);
			String reportPath = ConfigManager.INSTANCE.getConfig().getProperty("report.server");
			mv.addObject("reportPath", reportPath);
			String excelname = new String(StringUtils.defaultIfEmpty(request.getParameter("excelname"), "").getBytes("ISO-8859-1"), "UTF-8");
			mv.addObject("excelname", excelname);
			mv.setViewName("report/eba_new/Eba_DayCheck_BillManage");
		} catch (Exception e) {
			logger.error(e);
		}
		return mv;
	}

}
