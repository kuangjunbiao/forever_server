package com.gaoan.forever.util;

public class MessageUtil {
//	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
//
//		Map<String, String> map = new HashMap<String, String>();
//
//		// 从dom4j的jar包中，拿到SAXReader对象。
//
//		SAXReader reader = new SAXReader();
//
//		InputStream is = request.getInputStream();// 从request中，获取输入流
//
//		Document doc = reader.read(is);// 从reader对象中,读取输入流
//
//		Element root = doc.getRootElement();// 获取XML文档的根元素
//
//		List<Element> list = root.elements();// 获得根元素下的所有子节点
//
//		for (Element e : list) {
//
//			map.put(e.getName(), e.getText());// 遍历list对象，并将结果保存到集合中
//
//		}
//
//		is.close();
//
//		return map;
//
//	}
//
//	/**
//	 * 
//	 * 将文本消息对象转化成XML格式
//	 * 
//	 * @param message
//	 *            文本消息对象
//	 * 
//	 * @return 返回转换后的XML格式
//	 * 
//	 */
//
//	public static String objectToXml(TestMessage message) {
//
//		XStream xs = new XStream();
//
//		// 由于转换后xml根节点默认为class类，需转化为<xml>
//
//		xs.alias("xml", message.getClass());
//
//		return xs.toXML(message);
//
//	}
}
