package com.yysj.bangtang.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.yysj.bangtang.common.QueryEntity;

public class GenericUtils {
	
	/**
	 * mybatis的条件查询可以通过BeanExample来查询，为此可以通过BeanExample来构造查询条件
	 * @param clazz 
	 * @param qes 查询条件，
	 * @return clazz实例
	 */
	public static <E>  E buildCriteriaFromBean( Class<E> clazz,List<QueryEntity> qes){
		try {
			E objParent=clazz.newInstance();
			Method crateCriteria =clazz.getMethod("createCriteria", null);
			Object obj= crateCriteria.invoke(objParent, null);
			//获取方法
			for( QueryEntity qe :qes){
				//生成方法名,组成部分：and+属性名首字母大写+操作码首字母大写。如：andNameEqual
				StringBuffer methodName=new StringBuffer("and");
				methodName.append(qe.getAttribute()+qe.getOperation());
				Class<?>[] parasTypes=new Class[qe.getValues().size()];
				for(int j =0;j <qe.getValues().size();j++){
					parasTypes[j]=qe.getValues().get(j).getClass();
				}
				Method method= obj.getClass().getMethod(methodName.toString(),parasTypes);
				method.invoke(obj, qe.getValues().toArray());
			}
			return objParent;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
