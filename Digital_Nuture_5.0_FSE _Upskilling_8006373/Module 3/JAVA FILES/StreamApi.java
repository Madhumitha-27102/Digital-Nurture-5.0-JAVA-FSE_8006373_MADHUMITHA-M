package Practice;
import java.util.*;
import java.util.stream.*;
public class StreamApi {
	
	    public static void main(String[] args)
	    {
	        List<Integer> list = Arrays.asList(10, 15, 20, 25, 30, 35);

	        List<Integer> evenNumbers = list.stream()
	                                         .filter(n -> n % 2 == 0)
	                                         .collect(Collectors.toList());

	        System.out.println("Even Numbers: " + evenNumbers);
	    }
	}
