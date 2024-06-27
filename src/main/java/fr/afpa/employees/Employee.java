package fr.afpa.employees;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.time.temporal.ChronoUnit;

/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

public class Employee {
	/**
	 * Matricule de l'employé
	 */
	// compléter les attributs de classe comme présenté dans le PDF
	private String registrationNumber;
	private String lastName;
	private String firstName;
	private double salary;
	private final int socialRate = 30; // Ne va pas bouger, non modifiable
	private LocalDate birthday;

	// compléter le constructeur de la classes
	// Public est un modificateur d'accees qui déterminent la visibilité et
	// l'accessibilité des classes, méthodes, et variables depuis d'autres parties
	// du code
	// String retourne a une chaine de caracteres
	// Corps du constructeur où les attributs seront initialisés ce qu'on appelle
	// initialisation des attributs
	// Le constructeur Employee initialise un nouvel objet Employee avec les valeurs
	// fournies
	// Il utilise les paramètres pour assigner des valeurs aux attributs
	// correspondants de l'objet
	// avec une conversion de la chaîne de caractères de la date de naissance en
	// LocalDate.
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthday) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthday = LocalDate.parse(birthday); // Convertir la chaîne en LocalDate

	}

	// implementer les getters et les setters de la classe

	// l'implementation nous donne les donnees des getters
	// Public est un modificateur d'accees qui déterminent la visibilité et
	// l'accessibilité des classes, méthodes, et variables depuis d'autres parties
	// du code
	// String parametre de type String qui est une chaine de caracteres
	// getRegistationNumber est le nom de la methode donne au getters
	// elle retourne a une instance de class = objet
	
	// Getters
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public double getSalary() {
		return this.salary;
	}

	public int getSocialRate() {
		return this.socialRate;
	}

	public LocalDate getBirthday() {
		return this.birthday;
	}

	// public : La méthode est accessible depuis n'importe quelle autre classe
	// void : La méthode ne retourne aucune valeur
	// setRegistrationNumber : Le nom de la méthode, utilisé pour définir ou
	// modifier le matricule (registration number) de l'objet
	// String registrationNumber : Paramètre d'entrée de la méthode, de type String
	// (chaine de caractere) qui représente le nouveau matricule
	// throws Exception : Indique que cette méthode peut lancer une exception de type Exception
	// Vérification : La méthode checkRegistrationNumber est appelée pour vérifier si le nouveau matricule est valide
	// checkRegistrationNumber(registrationNumber) : C'est une méthode (non montrée ici) qui retourne un booléen (true ou false) en fonction de la validité du registrationNumber
	// Si valide (true) : La condition if (checkRegistrationNumber(registrationNumber) == true) est remplie 
	// this.registrationNumber = registrationNumber; : L'attribut de l'objet registrationNumber est mis à jour avec la nouvelle valeur.
	// Si invalide (false) : La condition else est exécutée.
	// throw new Exception("ERREUR: Le nouveau registrationNumber n'est pas valide
	// !"); : Une exception est levée, signalant que le nouveau matricule n'est pas
	// valide.
	
	// Setters
	public void setRegistrationNumber(String registrationNumber) throws Exception {
		// A ce niveau, tentative de modification du matricule
		// Nous devons vérifier le matricule !
		// ------> PROGRAMMING DEFENSIVE = vérification des paramètres d'entrée ->
		// registrationNumber
		if (checkRegistrationNumber(registrationNumber) == true) {
			// VRAI donc matricule correct = Modification matricule
			this.registrationNumber = registrationNumber;
		} else {
			// FAUX donc on fait qqch pour traiter ce cas
			// EXCEPTION = ERREUR
			throw new Exception("ERREUR: Le nouveau registrationNumber n'est pas valide !");
		}

	}

	public void setLastName(String lastName) throws Exception {
		if (checkName(lastName) == true) {
			this.lastName = lastName;
		} else {
			throw new Exception("ERREUR: Le lastName n'est pas valide !");
		}
	}

	public void setFirstName(String firstName) throws Exception {
		if (checkName(firstName) == true) {
			this.firstName = firstName;
		} else {
			throw new Exception("ERREUR: Le firstName n'est pas valide !");
		}
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBirthday(String birthday) throws Exception {
		if (checkBirthDate(birthday) == true) {
			this.birthday = LocalDate.parse(birthday);
		} else {
			throw new Exception("ERREUR: Le birthDay n'est pas valide !");
		}

	}
	// Implémenter les setters et getters de la classe (permet d'accéder aux
	// attributs public)

	// Implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	@Override
	public String toString() {
		return "Employee [\n registrationNumber=" + registrationNumber
				+ "\n lastName = " + getLastName()
				+ "\n firstName = " + getFirstName()
				+ "\n salary = " + getSalary()
				+ "\n netSalary = " + netSalary()
				+ "\n socialRate = " + socialRate
				+ "\n birthday = " + getBirthday()
				+ "\n nextBirthday = " + daysBeforeBirthday()
				+ "]";
	}

	public String fullName() {
		return this.lastName + this.firstName;
	}

	public double netSalary() {
		double netSalary = this.salary - this.salary * (this.socialRate / 100);
		return netSalary;
	}

	public long daysBeforeBirthday() {
		LocalDate currentDate = LocalDate.now();
		LocalDate nextBirthday = this.birthday.withYear(currentDate.getYear());

		if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
			nextBirthday = nextBirthday.plusYears(1);
		}
		return ChronoUnit.DAYS.between(currentDate, nextBirthday);
	}

	/**
	 * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel
	 * correctement formaté ou non
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un matricule, FAUX sinon
	 */
	private boolean checkRegistrationNumber(String inputToCheck) {

		// Vérification de la taille de la chaîne de caractères
		if (inputToCheck.length() != 7) {
			return false;
		}

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isRegistrationNumber = false;

		// Cette première boucle permet de passer en revue TOUS les caractères de la
		// chaîne
		for (int index = 0; index < inputToCheck.length(); index++) {
			// index = longueur de intupToCheck - 1 = 6
			char ch = inputToCheck.charAt(index);
			if (index == 0 || index == 1 || index == 5 || index == 6) {

				// vérification du caractère, s'agit-il d'un chiffre ?
				if (Character.isDigit(ch) == true) {
					isRegistrationNumber = true;
				} else { // attention, ce n'est pas un chiffre
					return false;
				}

			} else { // cas de la position 2, 3 ou 4 -> vérification de letter

				// Quelle opération dois-je faire ?
				if (Character.isLetter(ch)) {
					isRegistrationNumber = true;
				} else {
					return false;
				}
			}
		} // fin du FOR, BRAVO !

		return isRegistrationNumber;
	}

	/**
	 * Vérifie qu'une chaine de caractères passée en paramètre est un prénom ou un
	 * nom
	 * Pas de chiffres + caractères spé sauf '-'
	 * 
	 * @param inputToCheck La chaîne de caractères à vérifier
	 * @return VRAI s'il s'agit d'un prénom/nom correctement formaté, FAUX sinon
	 */

	private boolean checkName(String inputToCheck) {
		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté

		boolean isName = false;
		for (int index = 0; index < inputToCheck.length(); index++) {
			char ch = inputToCheck.charAt(index);
			if (Character.isLetter(ch) == true || ch == '-') { // rappel || -> ou
				isName = true;
			} else {
				return false;
			}
		}
		return isName;
	}

	/**
	 * Vérifie qu'une chaine de caractères passée en paramètre est une date de
	 * naissance
	 *
	 * @param inputToCheck La chaîne de caractères à vérifier
	 * @return VRAI s'il s'agit d'une date de naissance correctement formaté, FAUX
	 *         sinon
	 */
	private boolean checkBirthDate(String inputToCheck) {

		if (inputToCheck.length() != 10) {
			return false;
		}

		boolean isBirthDate = false;
		for (int index = 0; index < inputToCheck.length(); index++) {
			// index = longueur de intupToCheck - 1 = 9
			char ch = inputToCheck.charAt(index);
			if (index == 0 || index == 1 || index == 2 || index == 3 || index == 5 || index == 6 || index == 8
					|| index == 9) {

				// vérification du caractère, s'agit-il d'un chiffre ?
				if (Character.isDigit(ch) == true) {
					isBirthDate = true;
				} else { // attention, ce n'est pas un chiffre
					return false;
				}

			} else { // cas de la position 4 et 7 -> vérification -

				if (ch == '-') {
					isBirthDate = true;
				} else {
					return false;
				}
			}
		}
		return isBirthDate;
	}

	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
}