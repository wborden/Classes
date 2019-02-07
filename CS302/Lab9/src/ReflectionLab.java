
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Scanner;

/**
 * Class that takes in input as the class name followed by its constructor
 * parameters.
 * 
 */
public class ReflectionLab {
	
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Scanner scanner = new Scanner(System.in);

		// get the input from the user as space separated values
		String constructorInput = scanner.nextLine();

		// split from ' '
		String[] splitsInput = constructorInput.split(" ");
		
		for(String split: splitsInput){
			System.out.println(split);
		}
		//TODO work with splitsInput and then use Reflection API to
		//create an object of that type using that particular constructor
		
		
			createObject(splitsInput);
		
		scanner.close();
	}
	
	
	
	public static void createObject(String[] input) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		//Class toCreate = null;
		
		
		Constructor classParams = null;
		int params;
		
		try {
			Class toCreate =  Class.forName(input[0]);
			Constructor[] cons = toCreate.getConstructors();
		
		
		for(int i = 0; i < cons.length; i++) {
			
			 params = cons[i].getParameterCount();
			
			if (params == input.length - 1) {
				
				classParams = cons[i];
				
				break;
			}
		}
		
		Class[] p = classParams.getParameterTypes();
		
		Object[] obj = new Object[p.length];
		
		for(int i = 0; i < obj.length; i++) {
			
			obj[i] = getObject(p[i], input[i + 1]);
		}
		
		Object object = classParams.newInstance(obj);
		
		System.out.println(object);
		
		
		} catch (ClassNotFoundException e) { e.printStackTrace(); }	
		
	}

	/**
	 * Get the object of the class type out of the string token.
	 * 
	 * @param type
	 *            - type representing the class type of the string token
	 * @param value
	 *            - the string token to parse into the appropriate type
	 * @return the object representing the string token
	 * 
	 * @precondition value!=null and type!=null and type is one of integer,
	 *               float, double, boolean, character or string itself
	 */
	@SuppressWarnings("rawtypes")
	public static Object getObject(Class type, String value) {
		if (Integer.class.equals(type) || int.class == type) {
			return Integer.parseInt(value);
		} else if (Float.class.equals(type) || float.class == type) {
			return Float.parseFloat(value);
		} else if (Long.class.equals(type) || long.class == type) {
			return Long.parseLong(value);
		} else if (Double.class.equals(type) || double.class == type) {
			return Double.parseDouble(value);
		} else if (Boolean.class.equals(type) || boolean.class == type) {
			return Boolean.parseBoolean(value);
		} else if (Character.class.equals(type) || char.class == type) {
			return value.charAt(0);
		} else {
			return value; // at the end we assume its just a plain simple String
		}
	}
}
