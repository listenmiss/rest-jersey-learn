/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.media.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Administrator
 */
public class JaxbLearnTest {

    /**
     * @param object 对象
     * @return 返回xmlStr
     */
    public static String object2Xml(Object object) {
        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshal = context.createMarshaller();

            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出 
            marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8 
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息 
            marshal.setProperty("jaxb.encoding", "utf-8");
            marshal.marshal(object, writer);

            return new String(writer.getBuffer());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> T xml2Object(String xmlStr, Class<T> c) {
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            T t = (T) unmarshaller.unmarshal(new StringReader(xmlStr));

            return t;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void object2XmlDemo() {
        Department da = new Department();
        da.setId(1);
        da.setName("科室A");
        da.setCapacity(10);

        Department db = new Department();
        db.setId(2);
        db.setName("科室B");
        db.setCapacity(15);

        List<Department> departmentList = new ArrayList<Department>();
        departmentList.add(da);
        departmentList.add(db);

        Hospital h = new Hospital();
        h.setCode("h_1234");
        h.setId(1);
        h.setName("南京鼓楼医院");
        h.setDepartmentList(departmentList);
        String result = JaxbLearnTest.object2Xml(h);
        System.out.println(result);
    }
    
     public static void xml2ObjectDemo() {
         String xmlStr ="<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>\n" +
"<hospital id=\"1\">\n" +
"    <hospitalName>南京鼓楼医院</hospitalName>\n" +
"    <departments>\n" +
"        <dep id=\"1\">\n" +
"            <departmentName>科室A</departmentName>\n" +
"            <capacity>10</capacity>\n" +
"        </dep>\n" +
"        <dep id=\"2\">\n" +
"            <departmentName>科室B</departmentName>\n" +
"            <capacity>15</capacity>\n" +
"        </dep>\n" +
"    </departments>\n" +
"</hospital>";
         
        Hospital hop = JaxbLearnTest.xml2Object( xmlStr, Hospital.class);
         System.out.println(hop.toString());
         
     }

    public static void main(String[] args) {

        JaxbLearnTest.object2XmlDemo();
        System.out.println("``````````````````````````````````");
        JaxbLearnTest. xml2ObjectDemo();

    }

}
