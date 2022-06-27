import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter Ax");
			double Ax = input.nextDouble();
		System.out.print("Enter Ay");
			double Ay = input.nextDouble();
		System.out.print("Enter Bx");
			double Bx = input.nextDouble();
		System.out.print("Enter By");
			double By = input.nextDouble();
		System.out.print("Enter Cx");
			double Cx = input.nextDouble();
		System.out.print("Enter Cy");
			double Cy = input.nextDouble();
		input.close();
			double subTract1 = By - Cy;
			double subTract2 = Cy - Ay;
			double subTract3 = Ay - By;
				double muL1 = Ax * subTract1 ;
				double muL2 = Bx * subTract2 ;
				double muL3 = Cx * subTract3 ;
				double suM = muL1 + muL2 + muL3 ;
					double suM1 = suM / 2;
					int result = (int) Math.abs(suM1);
					System.out.print("Your triangle area is " + result);
					
	}

}


