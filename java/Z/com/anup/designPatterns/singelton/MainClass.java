package Z.com.anup.designPatterns.singelton;



public class MainClass {
	public static void main(String[] args) {
		SingeltonClass singeltonObject = SingeltonClass.getInstance();
		//singeltonObject.simpleMethod();
		System.out.println("hashcode of singelton object" + singeltonObject);
		
		
		SingeltonClass singeltonObject2 = SingeltonClass.getInstance();
		//singeltonObject2.simpleMethod();
		System.out.println("hashcode of singelton object2" + singeltonObject2);
		
		//now comparing to regular instance 
		Teacher teacher = new Teacher();
		System.out.println(teacher);
		
		Teacher teacher2 = new Teacher();
		System.out.println(teacher2);
	}

}
