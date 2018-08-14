package com.gaoan.forever.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoan.forever.base.AppException;
import com.gaoan.forever.base.BaseService;
import com.gaoan.forever.constant.MessageInfoConstant;
import com.gaoan.forever.constant.UserConstant;
import com.gaoan.forever.entity.TbPurchaseOrderEntity;
import com.gaoan.forever.entity.TbStockEntity;
import com.gaoan.forever.entity.TbUserEntity;
import com.gaoan.forever.mapper.TbPurchaseOrderMapper;
import com.gaoan.forever.mapper.TbStockMapper;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.model.result.PurchaseOrderInfoModel;
import com.gaoan.forever.service.ITbPurchaseOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 名称: TbPurchaseOrderServiceImpl 描述: 角色处理类 类型: JAVA
 * 
 */
@Service("TbPurchaseOrderServiceImpl")
public class TbPurchaseOrderServiceImpl extends BaseService<TbPurchaseOrderEntity> implements ITbPurchaseOrderService {

    private final Logger logger = LoggerFactory.getLogger(TbPurchaseOrderServiceImpl.class);

    @Autowired
    private TbPurchaseOrderMapper tbPurchaseOrderMapper;

    @Autowired
    private TbStockMapper tbStockMapper;

    @Override
    public PageInfo<PurchaseOrderInfoModel> queryPurchaseOrder(OrderQueryConditionModel condition, int page,
	    int pageSize) {
	PageHelper.startPage(page, pageSize);
	List<PurchaseOrderInfoModel> list = tbPurchaseOrderMapper.queryPurchaseOrder(condition);
	return new PageInfo<>(list);
    }

    @Transactional
    @Override
    public void insertPurchaseOrderByHave(PurchaseOrderInfoModel model) {
	if (model == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}

	String purchaseOrderName = model.getPurchaseOrderName();
	String goodsName = model.getGoodsName();
	BigDecimal costPrice = model.getCostPrice();
	Long quantity = model.getQuantity();

	if (StringUtils.isEmpty(purchaseOrderName) || StringUtils.isEmpty(goodsName) || costPrice == null
		|| quantity == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}
	purchaseOrderName = purchaseOrderName.trim();
	goodsName = goodsName.trim();

	if (costPrice.compareTo(BigDecimal.ZERO) <= 0 || quantity < 0) {
	    throw new AppException(MessageInfoConstant.DATAS_INFO_IS_NOT_EXIST);
	}

	// 修改库存
	TbStockEntity queryEntity = new TbStockEntity();
	queryEntity.setPurchaseOrderName(purchaseOrderName);
	queryEntity.setGoodsName(goodsName);
	TbStockEntity stockEntity = tbStockMapper.queryInfoByEntity(queryEntity);
	if (stockEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	int result = tbStockMapper.addQty(stockEntity.getId(), quantity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.NOT_ENOUGH_INVENTORY);
	}

	BigDecimal quantity_bd = new BigDecimal(quantity);
	// 算出总价
	BigDecimal total = costPrice.multiply(quantity_bd);

	TbUserEntity userEntity = (TbUserEntity) SecurityUtils.getSubject().getSession()
		.getAttribute(UserConstant.SESSION_LOGIN_USER_KEY);

	if (userEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	TbPurchaseOrderEntity purchaseOrderEntity = new TbPurchaseOrderEntity();
	purchaseOrderEntity.setGoodsId(stockEntity.getId());
	purchaseOrderEntity.setQuantity(quantity);
	purchaseOrderEntity.setCostPrice(costPrice);
	purchaseOrderEntity.setTotal(total);
	purchaseOrderEntity.setUserId(userEntity.getId());

	// 新增进货记录
	result = this.insertSelective(purchaseOrderEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}
    }

    @Transactional
    @Override
    public void insertPurchaseOrderByUnHave(PurchaseOrderInfoModel model) {
	if (model == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}

	String purchaseOrderName = model.getPurchaseOrderName();
	String goodsName = model.getGoodsName();
	BigDecimal costPrice = model.getCostPrice();
	Long quantity = model.getQuantity();

	if (StringUtils.isEmpty(purchaseOrderName) || StringUtils.isEmpty(goodsName) || costPrice == null
		|| quantity == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}

	if (costPrice.compareTo(BigDecimal.ZERO) <= 0 || quantity < 0) {
	    throw new AppException(MessageInfoConstant.DATAS_INFO_IS_NOT_EXIST);
	}

	purchaseOrderName = purchaseOrderName.trim();
	goodsName = goodsName.trim();

	// 修改库存
	TbStockEntity queryEntity = new TbStockEntity();
	queryEntity.setPurchaseOrderName(purchaseOrderName);
	queryEntity.setGoodsName(goodsName);
	TbStockEntity stockEntity = tbStockMapper.queryInfoByEntity(queryEntity);
	if (stockEntity != null) {
	    throw new AppException(MessageInfoConstant.PRODUCT_ALREADY_EXISTS);
	}

	queryEntity.setQuantity(quantity);
	int result = tbStockMapper.insertSelective(queryEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

//	result = tbStockMapper.addQty(queryEntity.getId(), quantity);
//	if (result < 1) {
//	    throw new AppException(MessageInfoConstant.NOT_ENOUGH_INVENTORY);
//	}

	BigDecimal quantity_bd = new BigDecimal(quantity);
	// 算出总价
	BigDecimal total = costPrice.multiply(quantity_bd);

	TbUserEntity userEntity = (TbUserEntity) SecurityUtils.getSubject().getSession()
		.getAttribute(UserConstant.SESSION_LOGIN_USER_KEY);

	if (userEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	TbPurchaseOrderEntity purchaseOrderEntity = new TbPurchaseOrderEntity();
	purchaseOrderEntity.setGoodsId(queryEntity.getId());
	purchaseOrderEntity.setQuantity(quantity);
	purchaseOrderEntity.setCostPrice(costPrice);
	purchaseOrderEntity.setTotal(total);
	purchaseOrderEntity.setUserId(userEntity.getId());

	// 新增进货记录
	result = this.insertSelective(purchaseOrderEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}
    }

    @Transactional
    @Override
    public void updatePurchaseOrder(PurchaseOrderInfoModel order) {
	if (order == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}
	Long id = order.getId();
	String purchaseOrderName = order.getPurchaseOrderName();
	String goodsName = order.getGoodsName();
	BigDecimal costlPrice = order.getCostPrice();
	Long quantity = order.getQuantity();

	if (id == null || StringUtils.isEmpty(purchaseOrderName) || StringUtils.isEmpty(goodsName) || costlPrice == null
		|| quantity == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}

	if (costlPrice.compareTo(BigDecimal.ZERO) <= 0 || quantity < 0) {
	    throw new AppException(MessageInfoConstant.DATAS_INFO_IS_NOT_EXIST);
	}

	purchaseOrderName = purchaseOrderName.trim();
	goodsName = goodsName.trim();

	TbPurchaseOrderEntity purchaseOrderEntity = this.queryByPrimaryKey(id);
	if (purchaseOrderEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	TbStockEntity queryEntity = new TbStockEntity();
	queryEntity.setPurchaseOrderName(purchaseOrderName);
	queryEntity.setGoodsName(goodsName);
	TbStockEntity newStockEntity = tbStockMapper.queryInfoByEntity(queryEntity);
	if (newStockEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	int compareResult;
	long diff;
	int result;
	// 修改库存
	if (purchaseOrderEntity.getGoodsId().longValue() == newStockEntity.getId().longValue()) {
	    // 同一件商品
	    compareResult = purchaseOrderEntity.getQuantity().compareTo(quantity);
	    if (compareResult > 0) {
		diff = purchaseOrderEntity.getQuantity().longValue() - quantity.longValue();
		result = tbStockMapper.subtractQty(newStockEntity.getId(), diff);
		if (result < 1) {
		    throw new AppException(MessageInfoConstant.NOT_ENOUGH_INVENTORY);
		}
	    } else if (compareResult < 0) {
		diff = quantity.longValue() - purchaseOrderEntity.getQuantity().longValue();
		result = tbStockMapper.addQty(newStockEntity.getId(), diff);
		if (result < 1) {
		    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
		}
	    }
	} else {
	    // 不同商品
	    // 原来商品减少库存
	    result = tbStockMapper.subtractQty(purchaseOrderEntity.getGoodsId(),
		    purchaseOrderEntity.getQuantity().longValue());
	    if (result < 1) {
		throw new AppException(MessageInfoConstant.NOT_ENOUGH_INVENTORY);
	    }

	    // 新商品新增库存
	    result = tbStockMapper.addQty(newStockEntity.getId(), quantity);
	    if (result < 1) {
		throw new AppException(MessageInfoConstant.NOT_ENOUGH_INVENTORY);
	    }
	}

	BigDecimal quantity_bd = new BigDecimal(quantity);
	// 算出总价
	BigDecimal total = costlPrice.multiply(quantity_bd);

	TbUserEntity userEntity = (TbUserEntity) SecurityUtils.getSubject().getSession()
		.getAttribute(UserConstant.SESSION_LOGIN_USER_KEY);

	if (userEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	TbPurchaseOrderEntity insertOrderEntity = new TbPurchaseOrderEntity();
	insertOrderEntity.setId(id);
	insertOrderEntity.setGoodsId(newStockEntity.getId());
	insertOrderEntity.setQuantity(quantity);
	insertOrderEntity.setCostPrice(costlPrice);
	insertOrderEntity.setTotal(total);
	insertOrderEntity.setUserId(userEntity.getId());

	// 修改进货记录
	result = this.updateByPrimaryKeySelective(insertOrderEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

    }

    @Transactional
    @Override
    public void delPurchaseOrder(Long orderId) {
	if (orderId == null) {
	    throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
	}

	TbPurchaseOrderEntity purchaseOrderEntity = this.queryByPrimaryKey(orderId);
	if (purchaseOrderEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	TbStockEntity stockEntity = tbStockMapper.queryByPrimaryKey(purchaseOrderEntity.getGoodsId());
	if (stockEntity == null) {
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}

	long result = tbStockMapper.subtractQty(stockEntity.getId(), purchaseOrderEntity.getQuantity().longValue());
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

	// 删除进货记录
	result = this.deleteByPrimaryKey(orderId);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

    }
}