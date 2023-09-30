
public class Person {
	
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String address;
	
	public Person(String name, String surname, String phone, String email, String address) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	@Override
    public String toString() {
        return name + "," + surname + "," + phone + "," + email + "," + address; 
    } 

	public void printDetails() {
		System.out.println("Name: " + getName() + " " + getSurname());
		System.out.println("Phone Number: " + getPhone());
		System.out.println("Email Address: " + getEmail());
		System.out.println("Physical Address: " + getAddress()); 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
