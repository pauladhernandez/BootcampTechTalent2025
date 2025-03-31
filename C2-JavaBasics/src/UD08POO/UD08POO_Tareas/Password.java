package UD08POO.UD08POO_Tareas;

import java.security.SecureRandom;

public class Password {

	private static final int LONGITUD_POR_DEFECTO = 8;
	private static final String CARACTERES = "ABCDEFGHIJKLMNÑOPQRSTUVXWYZabcdefghijklmnoñpqrstuvwxyz0213456789";
	private int longitud;
	private String contraseña;

	public Password() {
		this(LONGITUD_POR_DEFECTO);
	}

	public Password(int Longitud) {
		this.longitud = Longitud;
		this.contraseña = generarContraseña();
	}

	private String generarContraseña() {
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < longitud; i++) {
			sb.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
		}
		return sb.toString();
	}

	public int getLongitud() {
		return longitud;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String nuevaContraseña) {
		this.contraseña = nuevaContraseña;
		this.longitud = nuevaContraseña.length();
	}

	public static void main(String[] args) {
		Password pass1 = new Password();
		System.out.println("Contraseña por defecto: " + pass1.getContraseña());

		Password pass2 = new Password(8);
		System.out.println("Contraseña de 8 caracteres: " + pass2.getContraseña());

	}
}