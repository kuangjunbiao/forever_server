package com.gaoan.forever.apiServer.controller.stock;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaoan.forever.entity.TbStockEntity;
import com.gaoan.forever.model.Message;
import com.gaoan.forever.service.ITbStockService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/stock")
@Api(value = "StockController", description = "库存信息控制器")
public class StockController {

    @Autowired
    private ITbStockService tbStockService;

    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @ApiOperation(value = "获取库存列表")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "purchaseOrderName", value = "进货单名称", paramType = "query", dataType = "String", required = false),
	    @ApiImplicitParam(name = "goodsName", value = "商品名称", paramType = "query", dataType = "String", required = false),
	    @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int", required = false),
	    @ApiImplicitParam(name = "pageSize", value = "每页数据数", paramType = "query", dataType = "int", required = false) })
    @RequestMapping(value = "/getStockList", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.GET })
    @ResponseBody
    public Object getStockList(HttpServletRequest request, @RequestParam(required = false) String purchaseOrderName,
	    @RequestParam(required = false) String goodsName,
	    @RequestParam(required = false, defaultValue = "1") int page,
	    @RequestParam(required = false, defaultValue = "10") int pageSize) throws Exception {

	TbStockEntity stockEntity = new TbStockEntity();
	stockEntity.setPurchaseOrderName(purchaseOrderName);
	stockEntity.setGoodsName(goodsName);

	PageInfo<TbStockEntity> pageInfo = tbStockService.getStockPageInfo(stockEntity, page, pageSize);

	Message.Builder build = Message.newBuilder();
	build.put("pageInfo", pageInfo);

	return build.builldJson();
    }

    @ApiOperation(value = "获取进货单名称列表")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int", required = false),
	    @ApiImplicitParam(name = "pageSize", value = "每页数据数", paramType = "query", dataType = "int", required = false) })
    @RequestMapping(value = "/getPurchaseNameList", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.GET })
    @ResponseBody
    public Object getPurchaseNameList(HttpServletRequest request,
	    @RequestParam(required = false, defaultValue = "1") int page,
	    @RequestParam(required = false, defaultValue = "10") int pageSize) throws Exception {

	PageInfo<String> pageInfo = tbStockService.queryPurchaseNameList(page, pageSize);

	Message.Builder build = Message.newBuilder();
	build.put("pageInfo", pageInfo);

	return build.builldJson();
    }

    @ApiOperation(value = "根据进货单查询商品列表")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "purchaseOrderName", value = "进货单名称", paramType = "query", dataType = "String", required = false),
	    @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int", required = false),
	    @ApiImplicitParam(name = "pageSize", value = "每页数据数", paramType = "query", dataType = "int", required = false) })
    @RequestMapping(value = "/getGoodsList", produces = "application/json;charset=UTF-8", method = {
	    RequestMethod.GET })
    @ResponseBody
    public Object getGoodsList(HttpServletRequest request, @RequestParam(required = false) String purchaseOrderName,
	    @RequestParam(required = false, defaultValue = "1") int page,
	    @RequestParam(required = false, defaultValue = "10") int pageSize) throws Exception {

	PageInfo<String> pageInfo = tbStockService.queryGoodsList(purchaseOrderName, page, pageSize);

	Message.Builder build = Message.newBuilder();
	build.put("pageInfo", pageInfo);

	return build.builldJson();
    }

}
