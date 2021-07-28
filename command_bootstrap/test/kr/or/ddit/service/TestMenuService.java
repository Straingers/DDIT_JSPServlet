package kr.or.ddit.service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.dto.MenuVO;

public class TestMenuService {
	
	private MenuServiceImpl service;
	
	@Before
	public void init() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = 
					documentBuilder.
						parse("D:/A_TeachingMaterial/6.JspSpring/workspace/command_bootstrap/res/kr/or/ddit/context/application-context.xml");
			Element root = document.getDocumentElement();
			
			NodeList beans = root.getElementsByTagName("bean");
			Map<String, Object> applicationContext = ApplicationContext.getApplicationContext();
			
			for (int i = 0; i < beans.getLength(); i++) {
				Node bean = beans.item(i);
				if(bean.getNodeType() == Node.ELEMENT_NODE) {
					Element ele = (Element) bean;
					String id = ele.getAttribute("id");
					String classType = ele.getAttribute("class");
					
					Class<?> cls = Class.forName(classType);
					Object targetObj = cls.newInstance();
					
					applicationContext.put(id, targetObj);
				}
			}
			
			for(int i = 0; i < beans.getLength(); i++) {
				Node bean = beans.item(i);
				if(bean.getNodeType() == Node.ELEMENT_NODE) {
					Element eleBean = (Element) bean;

					NodeList properties = bean.getChildNodes();
					for(int j = 0; j < properties.getLength(); j++) {
						Node property = properties.item(j);
						if(property.getNodeType() == Node.ELEMENT_NODE) {
							Element ele = (Element) property;
							String name = ele.getAttribute("name");
							String ref = ele.getAttribute("ref-value");
							
							String setMethodName = "set" + name.substring(0, 1).toUpperCase()
												 + name.substring(1);
							
							String className = eleBean.getAttribute("class");
							Class<?> classType = Class.forName(className);
							
							Method[] methods = classType.getMethods();
							
							for(Method method : methods) {
								if(method.getName().equals(setMethodName)) {
									method.invoke(applicationContext.get(eleBean.getAttribute("id"))
												, applicationContext.get(ref));
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		service = (MenuServiceImpl) ApplicationContext.getApplicationContext().get("menuService");
		service.setMenuDAO(new MockMenuDAO());
	}
	
	@Test
	public void testSubMenuList() throws Exception {
		List<MenuVO> menuList = service.getSubMenuList("M010000");
		Assert.assertEquals(1, menuList.size());
		Assert.assertEquals("회원가입", menuList.get(0).getmName());
	}

}
