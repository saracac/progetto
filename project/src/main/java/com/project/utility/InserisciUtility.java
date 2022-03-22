package com.project.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.businesscomponent.model.Corsista;

public class InserisciUtility {

	public static InserisciUtility getFactory() {
		return new InserisciUtility();
	}

	public InserisciUtility() {

	}

	public static boolean isValidName(String nome) {
		try {
			String regex = "^([a-zA-Z]{2,29})$";
			Pattern p = Pattern.compile(regex);
//			Corsista corsista = new Corsista();
			if (nome == null) {
				return false;
			} 
//			else if (corsista.getNomeCorsista().length() <= 30) {
//				return true;
//			} 
			else {
				Matcher m = p.matcher(nome);
				return m.matches();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
	}

	public static boolean isValidSurname(String cognome) {
		try {
			String regex = "^([a-zA-Z]{2,29})$";
			Pattern p = Pattern.compile(regex);
//			Corsista corsista = new Corsista();
			if (cognome == null) {
				return false;
			}
//			} else if (corsista.getCognomeCorsista().length() <= 30) {
//				return true;
//			} 
			else {
				Matcher m = p.matcher(cognome);
				return m.matches();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}

	}
}
