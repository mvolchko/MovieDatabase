package system;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;



public class TypeFactory {
private SpecificDirectorOrCast search;
	
	
	

	public SpecificDirectorOrCast makeSearch(String searchName) {

			try {
				Class theClass = Class.forName("system."+searchName);
				
				// Find the right Constructor
				Class[] argumentTypes = {searchName.getClass()};
				Object[] arguments = {searchName};
				
				Constructor theConstructor = theClass.getConstructor(argumentTypes);
				
				return (SpecificDirectorOrCast) theConstructor.newInstance(arguments);
				
			} catch (ClassNotFoundException e) {
				System.err.println("The problem is with the class name.");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.err.println("The problem is with the method name and parameter list");
				e.printStackTrace();
			} catch (SecurityException e) {
				System.err.println("You don't have permission to access that method.");
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.err.println("The problem was in invoking the constructor");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.err.println("You don't have permission to access the constructor.");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.err.println("The problem is with the parameter in the method call.");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.err.println("The method or constructor threw an exception.");
				e.printStackTrace();
			}
			System.out.println("I am unable to create the Search.  Returning null.");
			return null;
		}

}
