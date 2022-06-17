package Z.com.anup.designPatterns.decorator;

public class HouseBlend implements Beverage {
	/*
	 * public HouseBlend() { description = "House Blend Coffee"; }
	 */
		 public double cost() {
		  return .89;
		 }

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "this is HouseBlend";
		}
}