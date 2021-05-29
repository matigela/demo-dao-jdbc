package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Teste 1: department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("=== Teste 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}

		System.out.println("=== Teste 3: department insert =====");
		Department newDepartment = new Department(null, "Buraco");
		departmentDao.insert(newDepartment);
		System.out.println("Insert the new id: " + newDepartment.getId());

		System.out.println("=== Teste 3: department update =====");
		newDepartment = departmentDao.findById(5);
		newDepartment.setName("System");
		departmentDao.update(newDepartment);
		System.out.println("Update the id: " + newDepartment.getId() + " - " + newDepartment.getName());

		System.out.println("=== Teste 4: department delete =====");
		System.out.println("Enter the id to delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete the id: " + id);
		
		sc.close();
	}
}
