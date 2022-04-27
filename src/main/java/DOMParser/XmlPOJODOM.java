package DOMParser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

public class XmlPOJODOM {
    List<Employee> employees = new ArrayList<>();    
    
	public void insertEmployeeXml(String firstname, String lastname, int salary ) throws ParserConfigurationException,		
	    SAXException, IOException, TransformerException {		

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document = builder.parse(new File("src/trainingXml/file_amostra.xml"));     
	        Element rootElement = document.getDocumentElement();
	        
	        Element employee = document.createElement("employee");	        
	        rootElement.appendChild(employee);	        
	        employee.setAttribute("id", "3001");
	        
	        Element elemfirstname = document.createElement("firstname");	        
	        elemfirstname.setTextContent(firstname);
	        employee.appendChild(elemfirstname);
	        
	        Element elemlastname = document.createElement("lastname");	        
	        elemlastname.setTextContent(lastname);
	        employee.appendChild(elemlastname);
	        
	        Element elemsalary = document.createElement("salary");	        
	        elemsalary.setTextContent(Integer.toString(salary));
	        employee.appendChild(elemsalary);        
	   
		try {    
	        writeXml(document, "C:/Users/renan/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/ProvaNina/src/trainingXml/file_amostra3.xml");	              
	        System.out.println("Deu");
		} catch (TransformerException e) {
			System.out.println("N�o eu");
		}
	}	
	
	  public static void writeXml(Document doc,
	              String output)
	      throws ParserConfigurationException, SAXException, IOException, TransformerException {
		  
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			// pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(output));
			
			transformer.transform(source, result);			
		}catch (TransformerException e) {
			
		}
	
	}	
	  
    public static void main(String[] args) throws ParserConfigurationException,
    SAXException, TransformerException, IOException {
    	try {
        	XmlPOJODOM pojo = new XmlPOJODOM() ;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:/Users/renan/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/ProvaNina/src/trainingXml/file_amostra.xml"));
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    String firstname = elem.getElementsByTagName("firstname")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    String lastname = elem.getElementsByTagName("lastname").item(0)
                            .getChildNodes().item(0).getNodeValue();
                    Double salary = Double.parseDouble(elem.getElementsByTagName("salary")
                            .item(0).getChildNodes().item(0).getNodeValue());
                    pojo.employees.add(new Employee(firstname, lastname, salary));
                }
                
            }
            for (Employee empl: pojo.employees)
                System.out.println(empl.toString());   
            
            pojo.insertEmployeeXml("renan", "rodolfo", 32000);    		
    	}catch (TransformerException e) {
			
		}
    }	
}

class Employee {
	
    private String Firstname;
    private String Lastname;
    private double salary;
    
    public Employee() {

    }
    
    public Employee(String Firstname, String Lastname, double salary) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "[" + Firstname + ", " + Lastname + ", "+ salary + "]";
    }

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
    
    
    
    
}
