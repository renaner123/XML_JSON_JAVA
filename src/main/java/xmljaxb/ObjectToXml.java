package xmljaxb;
// @Since 3.0.0, rebrand to jakarta.xml
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

// old APIs 2.3.*,
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class ObjectToXml {

    public static void main(String[] args) {

        JAXBContext jaxbContext = null;
        try {

            //jaxbContext = JAXBContext.newInstance(Company.class);

            // EclipseLink MOXy needs jaxb.properties at the same package with Company.class or Staff.class
            // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
            jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[] {Company.class}, null);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(createCompanyObject(), new File("src\\main\\resources\\company.xml"));

            //jaxbMarshaller.marshal(createCompanyObject(), System.out);

            // XML Unmarshalling
            /*File file = new File("C:\\test\\company.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Company o = (Company) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);*/

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private static Company createCompanyObject() {

        Company comp = new Company();
        comp.setName("ABCDEFG Enterprise");

        Staff o1 = new Staff();
        o1.setId(1);
        o1.setName("mkyong");
        o1.setSalary("8000 & Bonus");
        o1.setBio("<h1>support</h1>");
        o1.setJoinDate(ZonedDateTime.now().minusMonths(12));

        Staff o2 = new Staff();
        o2.setId(2);
        o2.setName("yflow");
        o2.setSalary("9000");
        o2.setBio("<h1>developer & database</h1>");
        o2.setJoinDate(ZonedDateTime.now().minusMonths(6));

        comp.setList(Arrays.asList(o1, o2));

        return comp;
    }
}