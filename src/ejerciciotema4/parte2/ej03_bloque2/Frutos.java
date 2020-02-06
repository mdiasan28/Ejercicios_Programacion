package ejerciciotema4.parte2.ej03_bloque2;

public class Frutos extends Arbol {

		String sabor;
		

		@Override
		public String toString() {
			return "Frutos [sabor=" + sabor + "]";
		}

		/**
		 * @param sabor
		 */
		public Frutos(String sabor) {
			super();
			this.sabor = sabor;
		}

		/**
		 * @return the sabor
		 */
		public String getSabor() {
			return sabor;
		}

		/**
		 * @param sabor the sabor to set
		 */
		public void setSabor(String sabor) {
			this.sabor = sabor;
		}
		
}
