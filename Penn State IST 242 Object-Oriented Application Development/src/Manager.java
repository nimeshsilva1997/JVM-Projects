public class Manager extends Employee {

	public Object[] department; // object class

	public void setDepartment(Object[] department) throws Exception {
		this.department = department; // current object that assigns the value of the parameter department to the
										// field of the same name
	}

	public Object[] getDepartment() throws Exception {
		return this.department; // returns current object
	}

}
