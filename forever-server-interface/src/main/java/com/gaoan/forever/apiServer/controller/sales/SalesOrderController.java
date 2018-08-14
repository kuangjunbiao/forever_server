package com.gaoan.forever.apiServer.controller.sales;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaoan.forever.model.Message;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.model.result.SalesOrderInfoModel;
import com.gaoan.forever.service.ITbSalesOrderService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/sales")
@Api(value = "SalesOrderController", description = "出货信息控制器")
public class SalesOrderController {

    @Autowired
    private ITbSalesOrderService tbSalesOrderService;

    private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);

    @ApiOperation(value = "获取出货列表")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "condition", value = "查询条件", paramType = "body", dataType = "json"),
	    @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int", required = false),
	    @ApiImplicitParam(name = "pageSize", value = "每页数据数", paramType = "query", dataType = "int", required = false) })
    @RequestMapping(value = "/getSalesOrderList", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.POST })
    @ResponseBody
    public Object getSalesOrderList(HttpServletRequest request, @RequestBody OrderQueryConditionModel condition,
	    @RequestParam(required = false, defaultValue = "1") int page,
	    @RequestParam(required = false, defaultValue = "10") int pageSize) throws Exception {

	PageInfo<SalesOrderInfoModel> pageInfo = tbSalesOrderService.querySalesOrder(condition, page, pageSize);

	Message.Builder build = Message.newBuilder();
	build.put("pageInfo", pageInfo);

	return build.builldJson();
    }

    @ApiOperation(value = "新增出货信息")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "order", value = "新增对象", paramType = "body", dataType = "json") })
    @RequestMapping(value = "/insertSalesOrder", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.POST })
    @ResponseBody
    public Object insertSalesOrder(HttpServletRequest request, @RequestBody SalesOrderInfoModel order) throws Exception {

	tbSalesOrderService.insertSalesOrder(order);

	Message.Builder build = Message.newBuilder();
	return build.builldJson();
    }

    @ApiOperation(value = "修改出货信息")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "order", value = "新增对象", paramType = "body", dataType = "json") })
    @RequestMapping(value = "/updateSalesOrder", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.POST })
    @ResponseBody
    public Object updateSalesOrder(HttpServletRequest request, @RequestBody SalesOrderInfoModel order) throws Exception {

	tbSalesOrderService.updateSalesOrder(order);

	Message.Builder build = Message.newBuilder();
	return build.builldJson();
    }

    @ApiOperation(value = "删除出货信息")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "orderId", value = "出货单编号", paramType = "query", dataType = "Long", required = true) })
    @RequestMapping(value = "/delSalesOrder", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.GET })
    @ResponseBody
    public Object delSalesOrder(HttpServletRequest request, @RequestParam(required = true) Long orderId)
	    throws Exception {

	tbSalesOrderService.delSalesOrder(orderId);

	Message.Builder build = Message.newBuilder();
	return build.builldJson();
    }
}
