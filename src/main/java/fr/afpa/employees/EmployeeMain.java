package fr.afpa.employees;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// Instanciez 4 objets de la classe "Employee" (une fois celle-ci implémentée)
		// Employee "c'est les types" employee1 'c'est le nom donnee au type" =
		// "operateur de fonction" new "opérateur d'instanciation" Employee "nom du
		// constructeur"
		try {
			Employee employee1 = new Employee("11ABC22", "Peppa", "Lavoyageuse", 2500, "1920-06-22");
			System.out.println(employee1.getRegistrationNumber());
			// Tentative de modification avec un matricule correctement formaté
			employee1.setRegistrationNumber("64AZE88");
			employee1.setLastName("Dora");
			employee1.setFirstName("Lexploratrice");

			Employee employee2 = new Employee("11ABC22", "Peppa", "Lavoyageuse", 2500, "1920-06-22");
			Employee employee3 = new Employee("12ABC33", "Super", "Man", 8000, "1980-12-31");
			Employee employee4 = new Employee("13ABC44", "Michel", "Michel", 1200, "2000-01-25");
			Employee employee5 = new Employee("14ABC55", "Crocodile", "Dundes", 2500, "1987-07-25");

			// afficher les informations des employés avec System.out.println
			ArrayList<Employee> listEmployees = new ArrayList<Employee>();
			listEmployees.add(employee1);
			listEmployees.add(employee2);
			listEmployees.add(employee3);
			listEmployees.add(employee4);
			listEmployees.add(employee5);

			for (Employee employee : listEmployees) {
				System.out.println(employee);
			}

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

	}
}