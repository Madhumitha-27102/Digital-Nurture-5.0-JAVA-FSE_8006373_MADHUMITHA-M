package Practice;

public class patternMatching {

	    public static void checkObject(Object obj)
	    {
	        switch(obj)
	        {
	            case Integer i -> System.out.println("It is an Integer: " + i);
	            case String s -> System.out.println("It is a String: " + s);
	            case Double d -> System.out.println("It is a Double: " + d);
	            default -> System.out.println("Unknown type");
	        }
	    }

	    public static void main(String[] args)
	    {
	        checkObject(10);
	        checkObject(10.0000);
	        checkObject(12.00876);
	       
	    }
	}
