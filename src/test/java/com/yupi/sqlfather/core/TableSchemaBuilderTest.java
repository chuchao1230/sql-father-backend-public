package com.yupi.sqlfather.core;


import cn.hutool.core.util.XmlUtil;
import com.yupi.sqlfather.core.schema.TableSchemaBuilder;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 表概要生成器测试
 *
 * @author https://github.com/liyupi
 */
class TableSchemaBuilderTest {

    @Test
    void getFieldTypeByValue() {
        System.out.println(TableSchemaBuilder.getFieldTypeByValue("123.4"));
    }

    @Test
    void buildFromXmlTest() {
        String xml = "<DATAHEAD>\n" +
                "<DATA_NAME>COL_D_LNF_AUTO_APRV_ABK_TAB</DATA_NAME>\n"+
                "<FIELDS>\n"+
                "<FIELD ID=\"1\" TYPE=\"varchar(40)\">id</FIELD>\n"+
                "<FIELD ID=\"2\" TYPE=\"varchar(32)\">cust_no</FIELD>\n"+
                "<FIELD ID=\"3\" TYPE=\"string\">cust_name</FIELD>\n"+
                "<FIELD ID=\"4\" TYPE=\"varchar(500)\">org_name</FIELD>\n"+
                "</FIELDS>\n"+
                "</DATAHEAD>";
        Document document = XmlUtil.parseXml(xml);
        Element dataNameElement = (Element) document.getElementsByTagName("DATA_NAME").item(0);
        String dataNameValue = dataNameElement.getTextContent();
        System.out.println("DATA_NAME 值为: " + dataNameValue);
        NodeList fieldList = document.getElementsByTagName("FIELD");
        for (int i = 0; i < fieldList.getLength(); i++) {
            Element fieldElement = (Element) fieldList.item(i);
            String type = fieldElement.getAttribute("TYPE");
            String fieldName = fieldElement.getTextContent();
            System.out.println("TYPE: " + type + " fieldName:" + fieldName);
        }
        //Element fields = XmlUtil.getElement(document, "DATA_NAME");
        //NodeList fieldList = fields.getChildNodes();
    }
}