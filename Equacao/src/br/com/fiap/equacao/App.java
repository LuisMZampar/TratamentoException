package br.com.fiap.equacao;

public class App {
	// x = -b + raiz(delta) / 2a
	// delta = b2 - 4ac
	
	double a = 0;
	double b = -6;
	double c = 10;
	double delta;
	double quadradoDeB;
	double raizDeDelta;
	double x1;
	double x2;
	
	public static void main(String[] args) {
		App app = new App();
		
		
		try {
			app.init();
		} catch (DivisaoPorZeroException e) {
			System.out.println("Divisão por zero");
			e.printStackTrace();
		} catch (DeltaNegativoException e) {
		System.out.println("Delta negativo");
			e.printStackTrace();
		}finally {
			
		}


		
	}

	private void init() throws DivisaoPorZeroException, DeltaNegativoException{
		calcularDelta();
		
		if(a == 0) 
			throw new ArithmeticException("Valor de a nao pode ser zero");

		
		x1 = (-b + raizDeDelta) / (2 * a);
		x2 = (-b - raizDeDelta) / (2 * a);
		
		mostrarResultado();
	}

	private void mostrarResultado() {
		System.out.println(x1);
		System.out.println(x2);

	}

	private void calcularDelta() throws DeltaNegativoException{
		// delta = b2 - 4ac
		calcularQuadradoDeB();
		delta = quadradoDeB - (4 * a * c);
		
		if(delta < 0)
			throw new DeltaNegativoException("Delta negativo");
		
		raizDeDelta = Math.sqrt(delta);
	}

	private void calcularQuadradoDeB() {
		quadradoDeB = Math.pow(b, 2);
	}

}
