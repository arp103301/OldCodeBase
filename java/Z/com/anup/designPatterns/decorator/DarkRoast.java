package Z.com.anup.designPatterns.decorator;

public class DarkRoast implements Beverage {
	 public DarkRoast() {
		 // description = "Dark Roast Coffee";
		 }
		 
		 public double cost() {
		  return .99;
		 }

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "this is DarkROast";
		}

}
