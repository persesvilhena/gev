package br.com.projeto.validador;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Validador {

		public static SimpleDateFormat formatadorDatas = new SimpleDateFormat("dd/MM/yyyy"); 
		
		public static boolean numero(String num) {
			boolean flag = true;
			
			try {
				Integer.parseInt(num);
			} catch (NumberFormatException e) {
				flag =  false;
			}

			return flag;
		}
		
		public static boolean numeroReal(String num) {
			boolean flag = true;
			
			try {
				Double.parseDouble(num);
			} catch (NumberFormatException e) {
				flag =  false;
			}

			return flag;
		}
		
		public static boolean data(String data) {
			boolean flag = true;
			
			try {
				formatadorDatas.parse(data);
			} catch (Exception e) {
				flag = false;
			} 

			return flag;
		}

		public static boolean cep(String cep) {
			cep = cep.replaceAll("-","");
	        return Pattern.matches("^\\d{8}$", cep);
		}
		
		public static boolean nome(String nome) {
			return Pattern.matches("^(\\p{L}+\\s)\\p{L}+$", nome);
		}
		
	}
