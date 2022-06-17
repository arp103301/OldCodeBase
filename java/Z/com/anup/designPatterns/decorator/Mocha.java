package Z.com.anup.designPatterns.decorator;

public class Mocha extends CondimentDecorator {
	 Beverage beverage;
	 
	 public Mocha(Beverage beverage) {
	  this.beverage = beverage;
	 }
	 
	 public String getDescription() {
	  return beverage.getDescription() + ", MochaDecorator";
	 }
	 
	 public double cost() {
	  return .20 + beverage.cost();
	 }
}
