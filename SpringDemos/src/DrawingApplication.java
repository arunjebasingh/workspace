import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	
	
	
	public static void main(String[] args) {

		int arr[] = {1,2,3,4};
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr[i]);
		}
		//Triangle triangle =  new Triangle();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
		
	}	

	
}