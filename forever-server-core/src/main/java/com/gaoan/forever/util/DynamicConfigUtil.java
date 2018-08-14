//package com.dotnar.trade.util;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import com.dotnar.base.AppException;
//import com.dotnar.constant.MessageInfoConstant;
//import com.dotnar.constant.RedisConstant;
//import com.dotnar.trade.entity.TbDynamicConfigInfoEntity;
//import com.dotnar.utils.cache.CacheUtils;
//import com.google.common.collect.Maps;
//
//@Component
//public class DynamicConfigUtil implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -4275506167106565323L;
//
//	
//	public static TbDynamicConfigInfoEntity getConfigByCache(String groupKey, String paramKey) {
//		if(StringUtils.isEmpty(groupKey) || StringUtils.isEmpty(paramKey)){
//			throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
//		}
//		String key = RedisConstant.KEY_HZ_HT_SYSTEMSET_PREFIX+groupKey;
//		TbDynamicConfigInfoEntity entity = (TbDynamicConfigInfoEntity) CacheUtils.getHashOpsByField(key, paramKey);
//		return entity;
//	}
//
//	@SuppressWarnings("unchecked")
//	public static Map<String, List<TbDynamicConfigInfoEntity>> getConfigByCache(String groupKey) {
//		Map<String, List<TbDynamicConfigInfoEntity>> result = new HashMap<String, List<TbDynamicConfigInfoEntity>>();
//		if(StringUtils.isEmpty(groupKey)){
//			throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
//		}
//		String key = RedisConstant.KEY_HZ_HT_SYSTEMSET_PREFIX+groupKey;
//		Map<String,Map<String,TbDynamicConfigInfoEntity>> m = (Map<String, Map<String, TbDynamicConfigInfoEntity>>) CacheUtils.getHashOps(key);
//    	for(Map.Entry<String,Map<String,TbDynamicConfigInfoEntity>> me : m.entrySet()){
//    		if(!result.containsKey(me.getKey())){
//    			List<TbDynamicConfigInfoEntity> tdielist = new ArrayList<TbDynamicConfigInfoEntity>();
//    			result.put(me.getKey(), tdielist);
//    		}
//    		result.get(me.getKey()).add((TbDynamicConfigInfoEntity)me.getValue());
//    	}
//		return result.isEmpty()?null:result;
//	}
//
//	@SuppressWarnings("unchecked")
//	public static Map<String, Map<String, List<TbDynamicConfigInfoEntity>>> getConfigAllByCache() {
//		Map<String, Map<String, List<TbDynamicConfigInfoEntity>>> result = Maps.newHashMap();
//		Map<String,String> syskeys = (Map<String, String>) CacheUtils.getHashOps(RedisConstant.KEY_HZ_HT_SYSTEMSET_KEY);
//		for(Map.Entry<String,String> sk : syskeys.entrySet()){
//			String key = sk.getKey();
//			Map<String, List<TbDynamicConfigInfoEntity>> configs = getConfigByCache(key);
//			if(configs!=null){
//				result.put(key, configs);
//			}
//		}
//		return result.isEmpty()?null:result;
//	}
//
//	
//	public static void removeCache(String groupKey, String paramKey) {
//		if(StringUtils.isEmpty(groupKey) || StringUtils.isEmpty(paramKey)){
//			throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
//		}
//		CacheUtils.delHashOpsByField(RedisConstant.KEY_HZ_HT_SYSTEMSET_PREFIX+groupKey, paramKey);
//	}
//
//	
//	public static void removeCache(String groupKey) {
//		if(StringUtils.isEmpty(groupKey)){
//			throw new AppException(MessageInfoConstant.PARAM_CANT_BE_NULL);
//		}
//		CacheUtils.del(RedisConstant.KEY_HZ_HT_SYSTEMSET_PREFIX+groupKey);
//		CacheUtils.delHashOpsByField(RedisConstant.KEY_HZ_HT_SYSTEMSET_KEY,groupKey);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public void removeCache() {
//		Map<String,String> groups = (Map<String, String>) CacheUtils.getHashOps(RedisConstant.KEY_HZ_HT_SYSTEMSET_KEY);
//		if(groups!=null){
//			for(Map.Entry<String, String> g : groups.entrySet()){
//				removeCache(g.getKey());
//			}
//		}
//	}
//	
//	public static String queryValueByRedisKeys(String paramkey, String groupkey) {
//		TbDynamicConfigInfoEntity config =  getConfigByCache(groupkey, paramkey);
//		return config!=null?config.getParamValue():"";
//	}
//}
