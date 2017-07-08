# Car-Gearbox


public class Main {

	public static void main(String[] args) {

		Gearbox mclaren = new Gearbox(6);
		
		mclaren.operateClutch(true);
		mclaren.addGear(1, 12.5);
		mclaren.addGear(2, 15.5);
		mclaren.addGear(3, 18.5);
		mclaren.addGear(4, 20.5);
		mclaren.addGear(5, 23.5);
		mclaren.addGear(6, 27.5);
		
		mclaren.changeGear(2);
		mclaren.operateClutch(false);

		System.out.println(mclaren.wheelSpeed(1000));
		
		
		
		
		
		
		
//		Gearbox mclaren = new Gearbox(6);
//
//		Gearbox.Gear first = mclaren.new Gear(1, 12.5);
//
//		System.out.println(first.driveSpeed(5));
//
//		Gearbox.Gear second = mclaren.new Gear(2, 15.5);
//
//		System.out.println(second.driveSpeed(8));

	}

}
import java.util.ArrayList;

public class Gearbox {

	private ArrayList<Gear> gears;
	private int maxGears;
	private int currentGear = 0;
	private boolean clutchIsIn;
	
	public void operateClutch( boolean in){
		this.clutchIsIn = in ;
	}
	
	public void addGear(int number, double ratio){
		if((number>0)&&(number<= maxGears)){
			this.gears.add(new Gear(number, ratio));
		}
	}
	
	public void changeGear(int newGear){
		if((newGear>0)&&(newGear<=this.gears.size())&&(this.clutchIsIn)){
			this.currentGear = newGear;
			System.out.println("Gear "+this.currentGear+" selected");
		} else {
			System.out.println("Grind");
			this.currentGear = 0;
		}
	}
	
	public double wheelSpeed(int revs){
		if(clutchIsIn){
			System.out.println("Scream");
			return 0;
		}
		return revs*gears.get(currentGear).getGearRatio(); 
	}
	
	public ArrayList<Gear> getGears() {
		return gears;
	}
	
	public void setGears(ArrayList<Gear> gears) {
		this.gears = gears;
	}
	public int getMaxGears() {
		return maxGears;
	}
	public void setMaxGears(int maxGears) {
		this.maxGears = maxGears;
	}
	public int getCurrentGear() {
		return currentGear;
	}
	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}
	public Gearbox(int maxGearsIn){
		this.maxGears = maxGearsIn;
		this.gears = new ArrayList<Gear>();
		Gear neutral = new Gear(0,0);
	}
	private class Gear{
		private int gearNumber;
		private double  gearRatio;
		
		public Gear(int gearNumberIn, double gearRatioIn){
			this.gearNumber = gearNumberIn;
			this.gearRatio = gearRatioIn;
		}
		
		public int getGearNumber() {
			return gearNumber;
		}

		public void setGearNumber(int gearNumber) {
			this.gearNumber = gearNumber;
		}

		public double getGearRatio() {
			return gearRatio;
		}

		public void setGearRatio(double gearRatio) {
			this.gearRatio = gearRatio;
		}

		public double driveSpeed(int revs){
			return revs*this.gearRatio;
		}
	}
}
