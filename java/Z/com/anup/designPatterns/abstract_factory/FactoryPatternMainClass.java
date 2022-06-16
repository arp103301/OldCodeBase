package Z.com.anup.designPatterns.abstract_factory;

import java.util.Optional;

public class FactoryPatternMainClass {
	
	public static void main(String[] args) {
	AbstractFactory abstractFactory =AbstractFactoryProducer.getProfession(true);
	Profession eng = abstractFactory.getProfession("Engineer");
	eng.print();
		
		
	}

}
