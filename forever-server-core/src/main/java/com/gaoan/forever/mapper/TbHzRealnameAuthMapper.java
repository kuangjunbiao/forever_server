package com.gaoan.forever.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gaoan.forever.base.BaseMapper;
import com.gaoan.forever.dbmodel.HzRealnameAuthDbModel;
import com.gaoan.forever.dbmodel.RealnameAuthDbModel;
import com.gaoan.forever.entity.TbHzRealnameAuthEntity;

/**
 * 名称: TbHzRealnameAuthMapper 描述: 实名认证信息Mapper接口 类型: JAVA
 * 
 * @since 2018-03-27
 * @author three
 */
public interface TbHzRealnameAuthMapper extends BaseMapper<TbHzRealnameAuthEntity> {

    public List<Map<String, Object>> queryByEntity(RealnameAuthDbModel entity);

    HzRealnameAuthDbModel queryByUserId(@Param("userId") Long userId);

    HzRealnameAuthDbModel queryInfoNew(@Param("realnameAuth") TbHzRealnameAuthEntity realnameAuth);

    int batchInsert(List<TbHzRealnameAuthEntity> list);

    int updateUserAuthStatus(@Param("userId") Long userId, @Param("status") int status,
	    @Param("lockStatus") int lockStatus);

    TbHzRealnameAuthEntity queryValidData(@Param("authId") Long authId, @Param("makeysUserName") String makeysUserName,
	    @Param("realName") String realName, @Param("idNum") String idNum);

}