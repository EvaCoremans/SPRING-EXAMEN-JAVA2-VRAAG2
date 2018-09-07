package edu.ap.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.ap.spring.Exam;
import java.awt.Point;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    
	@Autowired
	private Exam exam;

	@Autowired
	private Singleton singleton;	
	   
    @Test
    public void testgetPrimes() {
    		int[] intArray = new int[] { 11, 12, 13, 20, 25, 30, 37, 41, 50, 62, 78 };
    		int[] result = exam.getPrimes(intArray);
    		int[] expected = { 11, 13, 37, 41 };
    		if(Arrays.equals(result, expected)) {
    			singleton.setGrade(2, "testgetPrimes");
    		}	
    }
    
    @Test
    public void testgetReverse() {
    		String result = exam.getReverse("laat de zon in je hart");
    		if(result.equalsIgnoreCase("trah ej ni noz ed taal")) {
    			singleton.setGrade(2, "testgetReverse");
    		}
    }

    @Test
    public void testgetAverageY() {
    		int result = exam.getAverageY(this.makePointsList());
    		if(result == 5) {
    			singleton.setGrade(2, "testgetAverageY");
    		}
    }

    @Test
    public void getFileChanged() {
    		String path = SpringTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    		File f = new File(path.substring(0, path.indexOf("/target")) + "/src/test/java/edu/ap/spring/test/SpringTest.java");
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    		System.out.println("SpringTest last modified : " + sdf.format(f.lastModified()));
    }
    
    private List<Point> makePointsList() {
        List<Point> result = new ArrayList<>();
        result.add(new Point(-4, 8));
        result.add(new Point(-2, 9));
        result.add(new Point(-1, 8));
        result.add(new Point(0, 7));
        result.add(new Point(1, 1));
        result.add(new Point(2, 3));
        result.add(new Point(2, 3));
        result.add(new Point(2, 1));

        return result;
    }
}
