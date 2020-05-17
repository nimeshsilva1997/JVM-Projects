
public class Employee {
	public String strName, strSalary;

	public Employee() {
		strName = " ";
		strSalary = "$0";
	}

	public Employee(String Name, String Salary) {
		strName = Name;
		strSalary = Salary;
	}

	public void setName(String Name) {
		strName = Name;
	}

	public void setSalary(String Salary) {
		strSalary = Salary;
	}

	public String getName() {
		return strName;
	}

	public String getSalary() {
		return strSalary;
	}

	@Override
	public String toString() {
		return (strName + " has a salary of " + strSalary);
	}

}
