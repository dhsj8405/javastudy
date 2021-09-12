package prob6;

public class Rectangle extends Shape implements Resizable {
	private static double width;
	private static double height ;
	
	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}
//	public void Rectangle(double w, double h){
//		
//	}
	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

	@Override
	public double getArea() {
		return width * height ;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2 ;
	}

}
