package Z.com.anup.designPatterns.singelton;

public class SingeltonClass {
	
	
	private static SingeltonClass singletonInstance = new SingeltonClass();
	 
	private SingeltonClass(){
		 
	 }

	//Get the only object available
	   public static SingeltonClass getInstance(){
	      return singletonInstance;
	   }
	   
		/*
		 * public void simpleMethod() {
		 * System.out.println("hashcode of singelton object" + singletonInstance); }
		 */
	   
}
