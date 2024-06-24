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
	// compléter les attributs comme présenté dans le PDF
	private String registrationNumber;
	private String lastName;
	private String firstName;
	private double salary;
	private final int socialRate = 30;
	private LocalDate birthday;

	// compléter le constructeur de la classes
	public Employee(String registrationNumber, String lastName, String firstName, double salary,
			String birthday) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthday = LocalDate.parse(birthday);

	}

	// ajouter les getters et les setters

	// Getters
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getSalary() {
		return salary;
	}

	public int getSocialRate() {
		return socialRate;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	// Setters
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;

		// Implémenter les setters et getters de la classe (permet d'accéder aux
		// attributs privés)

	}

	// Implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	@Override
	public String toString() {
		return "Employee [\n registrationNumber=" + registrationNumber
				+ "\n lastName=" + lastName
				+ "\n firstName=" + firstName
				+ "\n salary=" + salary
				+ "\n socialRate=" + socialRate
				+ "\n birthday=" + birthday + "]";
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
		return ChronoUnit.DAYS.between(currentDate, currentDate);
	}

/**
     * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel correctement formaté ou non
     * @param inputToCheck La chaîne de caractère à vérifier
     * @return VRAI s'il s'agit d'un matricule, FAUX sinon
     */
    private boolean checkRegistrationNumber(String inputToCheck) {

        // Vérification de la taille de la chaîne de caractères
        if (inputToCheck.length() != 7) {
            return false;
        }

        // déclaration du booléen qui va stocker le résultat de la vérification
        // VRAI -> la chaîne de caractères passée en paramètre est un matricule correctement formaté
        // FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien formaté
        boolean isRegistrationNumber = false;

        // Cette première boucle permet de passer en revue TOUS les caractères de la chaîne
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


	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
}