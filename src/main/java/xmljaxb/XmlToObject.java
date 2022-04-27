package xmljaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlToObject {

  public static void main(String[] args) {

      JAXBContext jaxbContext = null;
      try {

          // Normal JAXB RI
          //jaxbContext = JAXBContext.newInstance(Fruit.class);

          // EclipseLink MOXy needs jaxb.properties at the same package with Fruit.class
          // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
          jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                  .createContext(new Class[]{Company.class}, null);

          File file = new File("src\\main\\resources\\company.xml");

          Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

          Company o = (Company) jaxbUnmarshaller.unmarshal(file);

          for (Staff staff : o.getList()) {
        	  System.out.println(staff.toString());
          }              

      } catch (JAXBException e) {
          e.printStackTrace();
      }

  }

}