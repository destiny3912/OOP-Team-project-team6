package Program;

public class Snack extends stockReadymade {
	private String snackOrigin;//������
	
	public String getOrigin() {
		return snackOrigin;
	}
	public void setOrigin(String snackOrigin) {
		this.snackOrigin = snackOrigin;
	}
	@Override
	public String toString() {
		String str = "Origin: " + snackOrigin + "\n";
		return super.toString() + str;
	}
}
