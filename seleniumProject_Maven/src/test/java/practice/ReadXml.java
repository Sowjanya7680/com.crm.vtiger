package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadXml {
	
	@Test
	public void readxml(XmlTest xml)
	{
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));
	}
	}


