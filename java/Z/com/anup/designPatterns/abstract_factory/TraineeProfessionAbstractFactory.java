package Z.com.anup.designPatterns.abstract_factory;

public class TraineeProfessionAbstractFactory extends AbstractFactory{
	
	@Override
	public Profession getProfession(String typeOfProfession){
	      
		  if(typeOfProfession == null){
	         return null;
	      }		
	         
		  else if(typeOfProfession.equalsIgnoreCase("Engineer")){
	         return new TraineeEngineer();//traineeEngineer obj
	         
	      } else if(typeOfProfession.equalsIgnoreCase("Teacher")){
	         return new TraineeTeacher();
	      }
	      
	      return null;
	   }

}
