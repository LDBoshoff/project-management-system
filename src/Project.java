import java.time.LocalDate;

public class Project {
	
	private String number;
	private String name;
	private String type;
	private String address;
	private String erf;
	private Double cost;
	private Double paid;
	private LocalDate deadline;
	private Person architect;
	private Person contractor;
	private Person customer;
	private boolean completed;
	private LocalDate completionDate;
    
	// a new project's attribute values are automatically set upon creation and change via setter methods containing user input
	public Project(String number, String name, String type, String address, String erf, Double cost, Double paid, 
			LocalDate deadline, Person architect, Person contractor, Person customer) {
		this.number = number;
        this.name = name;
        this.type = type;
        this.address = address;
        this.erf = erf;
        this.cost = cost;
        this.paid = paid;
        this.deadline = deadline;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
        this.completed = false;
        this.completionDate = null;
	}
	
	@Override
    public String toString() {
		String completionDateString = completionDate != null ? GetInput.dateToString(completionDate) : "";
        return number + "," + name + "," + type + "," + address + "," + erf + "," + GetInput.doubleToString(cost) + ","
                + GetInput.doubleToString(paid) + "," + GetInput.dateToString(deadline) + "," + architect + "," + contractor + ","
                + customer + "," + completed + "," + completionDateString; 
    } 
	
	public void printDetails() {

        System.out.println("1) Number: " + getNumber());
        System.out.println("2) Name: " + getName());
        System.out.println("3) Type: " + getType());
        System.out.println("4) Address: " + getAddress());
        System.out.println("5) ERF: " + getErf());
        System.out.println("6) Cost: " + GetInput.doubleToString(cost));
        System.out.println("7) Paid: " + GetInput.doubleToString(paid));
        System.out.println("8) Deadline: " + GetInput.dateToString(deadline));
        System.out.println("9) Architect:");
        architect.printDetails();
        System.out.println("10) Contractor:");
        contractor.printDetails();
        System.out.println("11) Customer:");
        customer.printDetails();
        System.out.println("12) Completed: " + getStatus());
        
        if (completed) {
        	System.out.println("13) Completion Date: " + GetInput.dateToString(completionDate));
        }
	}

	public boolean isOverdue() {
		LocalDate currentDate = LocalDate.now();
		
		return deadline.isBefore(currentDate);
	}
	
	private double outstandingCost() {
		return cost - paid;
	}
	
	public void finalise() {
			
		// Uncompleted projects are set to true and an invoice generated if there are fees outstanding
		if (getStatus()) {
			System.out.println("Project already completed.");
			return;
		} 
		
		setStatus(true); 
		LocalDate currentDate = LocalDate.now();
		currentDate = GetInput.formatDate(currentDate);
		setCompletionDate(currentDate);
		System.out.println("Project marked complete!\n");
		generateInvoice();
		
			
		return;
	}
	
	private void generateInvoice() {
        double outstandingAmount = outstandingCost();
        
        if (outstandingAmount <= 0) {
            System.out.println("The customer has already paid the full fee!\n");
            return;
        }
        
        System.out.println("----------------------------------");
        System.out.println("Invoice for Project: " + getNumber() + ", " + getName());       
        System.out.println("Customer: ");
        customer.printDetails();
        System.out.println("Total Amount Due: R " + outstandingAmount);
    }

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getErf() {
		return erf;
	}

	public void setErf(String erf) {
		this.erf = erf;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getPaid() {
		return paid;
	}

	public void setPaid(Double paid) {
		this.paid = paid;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Person getArchitect() {
		return architect;
	}

	public void setArchitect(Person architect) {
		this.architect = architect;
	}

	public Person getContractor() {
		return contractor;
	}

	public void setContractor(Person contractor) {
		this.contractor = contractor;
	}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public boolean getStatus() {
		return completed;
	}

	public void setStatus(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	
	
}