// File: ReflectionDemo.java

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

    public void showMessage(String name) {
        System.out.println("Hello " + name);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        try {
            // Load class dynamically
            Class<?> cls = Class.forName("ReflectionDemo");

            // Create object dynamically
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get all declared methods
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("Methods in class:");
            for (Method m : methods) {
                System.out.println("\nMethod Name: " + m.getName());

                // Print parameters
                Parameter[] params = m.getParameters();
                System.out.print("Parameters: ");
                for (Parameter p : params) {
                    System.out.print(p.getType().getSimpleName() + " " + p.getName() + "  ");
                }
                System.out.println();

                // Invoke methods dynamically (only for demo)
                if (m.getName().equals("showMessage")) {
                    m.invoke(obj, "Akshaya");
                }

                if (m.getName().equals("add")) {
                    Object result = m.invoke(obj, 10, 20);
                    System.out.println("Result = " + result);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}