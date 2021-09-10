package prob3;

public abstract class Bird {
	protected String name;
	protected abstract void setName(String string);

	public abstract void fly();
	public abstract void sing();

}