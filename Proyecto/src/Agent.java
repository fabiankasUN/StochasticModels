import java.util.Random;

public class Agent {

	public static final String DOLAR = "Dolar";
	public static final String COP = "Peso Colombiano";
	public static final String SOL = "Sol";
	public static final String FRANCOS = "Francos";
	public static final String REAL = "Real";
	public static final String LIBRA = "Libra";
	public static final String YEN = "Yen";
	public static final String EURO = "Euro";
	public static String divisas[] = { DOLAR, COP, SOL, FRANCOS, REAL, LIBRA, YEN, EURO };
	
	public static double initPrices[][] = { { 1, 3060, 3.34, 0.99, 3.6, 0.68, 110.280, 0.89 },
			{ 0.003, 1, 0.0001, 0.00032, 0.0012, 0.00022, 0.036, 0.00029 },
			{ 0.299, 912.56, 1, 0.297, 1.081, 0.204, 33.01, 0.269 },
			{ 1.0052, 3083.52, 3.366, 1, 3.633, 0.687, 110.805, 0.904 },
			{ 0.277, 848.81, 0.927, 0.275, 1, 0.189, 30.50, 0.249 },
			{ 1.462, 4485.27, 4.897, 1.454, 5.284, 1, 161.177, 1.315 },
			{ 0.00906, 27.643, 0.0302, 0.00901, 0.032, 0.00620, 1, 0.0081 },
			{ 1.112, 3409.66, 3.723, 1.106, 4.017, 0.76, 122.525, 1 } };
	public boolean avaliableCurrency[];

	private String ip;
	private double price[][];

	public Agent(String ip) {
		Random r = new Random();
		this.ip = ip;
		avaliableCurrency = new boolean[initPrices.length];
		price = new double[initPrices.length][initPrices.length];
		for (int i = 0; i < initPrices.length; i++) {
			for (int j = 0; j < initPrices.length; j++) {
				price[i][j] = initPrices[i][j];
			}
		}
		for (int i = 0; i < initPrices.length; i++) {
			avaliableCurrency[i] = r.nextBoolean();
		}
	}

	public void change() {
		Random r = new Random();
		for (int i = 0; i < initPrices.length; i++) {
			for (int j = 0; j < initPrices.length; j++) {
				double percent = r.nextDouble() * 0.01;
				price[i][j] += r.nextBoolean() ? ((price[i][j]) * percent) : (-(price[i][j]) * percent);
			}
		}
	}

	public void changeCurrency() {
		Random r = new Random();
		avaliableCurrency[r
				.nextInt(avaliableCurrency.length)] = !avaliableCurrency[r.nextInt(avaliableCurrency.length)];
	}

	public void printMatrix() {
		for (int i = 0; i < initPrices.length; i++) {
			for (int j = 0; j < initPrices.length; j++) {
				System.out.print(price[i][j] + " ");
			}
			System.out.println();
		}
	}

//	public static void main(String args[]) throws InterruptedException {
//		Agent a = new Agent("10.0.0.1");
//		while (true) {
//			a.change();
//			a.printMatrix();
//			System.out.println();
//			Thread.sleep(5000);
//		}
//
//	}
	
	
	
	
}
