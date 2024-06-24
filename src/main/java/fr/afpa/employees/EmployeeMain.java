package fr.afpa.employees;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// Instanciez 4 objets de la classe "Employee" (une fois celle-ci implémentée)
// Employee "c'est les types" employee1 'c'est le nom donnee au type" = "operateur de fonction" new "opérateur d'instanciation" Employee "nom du constructeur"
		Employee employee1 = new Employee("11ABC22", "Dora", "Lexploratrice", 2500, "1920-06-22");

		System.out.println(employee1.getRegistrationNumber());
		 // Tentative de modification avec un matricule correctement formaté
		 employee1.setRegistrationNumber("64AZE88");

		 // test des matricules en erreur
		 employee1.setRegistrationNumber("EEAZE88");
 
		 employee1.setRegistrationNumber("6444433");
 
		 employee1.setRegistrationNumber("64AZ");
 
		 employee1.setRegistrationNumber("6");
 
		 employee1.setRegistrationNumber("");
		 
		 employee1.setRegistrationNumber("987654");

		// TODO afficher les informations des employés avec System.out.println
		System.out.println(employee1.toString());

	}

}

// Employee employee2 = new Employee("12ABC33", "Super", "Man", 8000,
// 1980-12-31);
// Employee employee3 = new Employee("13ABC44", "Michel", "Michel", 1200),
// 2000-01-25;
// Employee employee4 = new Employee("14ABC55", "Crocodile", "Dundes", 2500,
// 1987-07-25);
// System.out.println(employee2.toString());
// System.out.println(employee3.toString());
// System.out.println(employee4.toString());