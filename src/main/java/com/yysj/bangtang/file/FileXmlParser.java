package com.yysj.bangtang.file;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class FileXmlParser implements FilePath{

	private Map<String,String> pathMaps=new HashMap<String, String>();
	
	public FileXmlParser() {
		super();
		String config ="filesavepath.xml";
		init(config);
	}
	/**
	 * config必修放在classes目录下
	 * @param config
	 */
	public FileXmlParser(String config){
		init(config);
	}
	private void init(String config){
		try{
			InputStream is= FileXmlParser.class.getClassLoader().getResourceAsStream(config);
		
			//1.创建解析器
	        SAXReader reader = new SAXReader();
	        //2.加载配置文件=document对象
	        Document doc = null;
	        doc = reader.read(is);
	        //3.定义xpath表达式，取出所有的relativepath元素
	        String xpath="//relativepath";
	        //4.对relativepath元素进行遍历
            List<Element> list = doc.selectNodes(xpath);
            if(list !=null)
            for( Element el : list){
            	String id=el.attributeValue("id");
            	String value = el.attributeValue("value");
            	pathMaps.put(id, value);
            }
            //根目录
            Element el =  doc.getRootElement();
            String id =el.attributeValue("id");
            String value = el.attributeValue("value");
            pathMaps.put(id, value);
            
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public String getPath(String id) {
		// TODO Auto-generated method stub
		return pathMaps.get(id);
	}
}
