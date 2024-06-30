package modelo;

public class EstadoCielo {
		
	
		String estado;
		String numero;

		public EstadoCielo(String estado, String numero) {
			super();
			this.estado = estado;
			this.numero = numero;

		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		@Override
		public String toString() {
			return "EstadoCielo [estado=" + estado + ", numero=" + numero + "]";
		}


		
		
		
		
}
