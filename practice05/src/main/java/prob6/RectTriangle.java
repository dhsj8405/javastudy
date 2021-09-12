package prob6;

public class RectTriangle extends Shape {
	private static double width;
	private static double height ;
	
	public RectTriangle(double w, double h){
		width = w;
		height = h;
		}
	@Override
	public double getArea() {
		return width * height /2;
	}

	@Override
	public double getPerimeter() {
		return width+height + Math.sqrt(width*width + height*height);
	}

}
