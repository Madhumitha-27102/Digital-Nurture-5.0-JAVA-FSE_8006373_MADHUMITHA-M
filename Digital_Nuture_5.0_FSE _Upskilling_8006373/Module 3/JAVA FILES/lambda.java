package Practice;
import java.util.*;
public class lambda {

	    public static void main(String[] args)
	    {
	        List<String> list = new ArrayList<>();

	        list.add("Madhumitha");
	        list.add("SunilKumar");
	        list.add("Riya");
	        list.add("Revi");

	        Collections.sort(list, (a, b) -> a.compareTo(b));

	        System.out.println("Sorted List: " + list);
	    }
	}
