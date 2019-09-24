package com.other.updown.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.cglib.beans.BeanMap;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 对象操作工具类
 *
 * @author huangyujie
 * @since 2019/4/23 10:32
 */
public class ObjectUtil {
	/**
	 * 将对象装换为map
	 * 
	 * @param bean
	 * @return
	 */
	public static <T> Map<String, Object> beanToMap(T bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bean != null) {
			BeanMap beanMap = BeanMap.create(bean);
			for (Object key : beanMap.keySet()) {
				map.put(key + "", beanMap.get(key));
			}
		}
		return map;
	}

	/**
	 * 将map装换为javabean对象
	 * 
	 * @param map
	 * @param bean
	 * @return
	 */
	public static <T> T mapToBean(Map<String, Object> map, T bean) {
		BeanMap beanMap = BeanMap.create(bean);
		beanMap.putAll(map);
		return bean; 
	}
	/**
	 * 方法说明：map转化为对象
	 * 
	 * @param map
	 * @param t
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T mapToObject(Map<String, Object> map, Class<T> t) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		T instance = t.newInstance();
		//注册日期格式化器 start
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy-MM-dd HH:mm");
		ConvertUtils.register(converter, Date.class);
		//注册日期格式化器 end
		BeanUtils.populate(instance, map);
		return instance;
	}

	/**
	 * 将List<T>转换为List<Map<String, Object>>
	 * 
	 * @param objList
	 * @return
	 * @throws JsonGenerationException
	 * @throws IOException
	 */
	public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		if (objList != null && objList.size() > 0) {
			Map<String, Object> map = null;
			T bean = null;
			for (int i = 0, size = objList.size(); i < size; i++) {
				bean = objList.get(i);
				map = beanToMap(bean);
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * 将List<Map<String,Object>>转换为List<T>
	 * 
	 * @param maps
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps,
			Class<T> clazz) throws InstantiationException,
			IllegalAccessException, InvocationTargetException {
		List<T> list = new ArrayList<T>();
		if (maps != null && maps.size() > 0) {
			Map<String, Object> map = null;
			T bean = null;
			for (int i = 0, size = maps.size(); i < size; i++) {
				map = maps.get(i);
				bean = mapToObject(map,clazz);
				list.add(bean);
			}
		}
		return list;
	}

}