import java.time.LocalDate;

public class ProjectUpdater {
	
	private static ProjectUpdater instance;
	
	private ProjectUpdater() { 
		
	}
	
	public static ProjectUpdater getInstance() {
		if (instance == null) {
			instance = new ProjectUpdater();
		}
		
		return instance;
	}
	

	public Project updateAttribute(Project project) {
		int choice = -1;
		
		while (choice != 0) {
			System.out.println("--------------------------------------------------");
			choice = GetInput.getIntegerInRange("1-12) Update attribute\n0) Go back\n\nEnter choice", 0, 12);
			project = setAttribute(project, choice);
		
		}
		return project;
	}
	
	private Project setAttribute(Project project, int choice) {
		switch (choice) {
		
			case 0: 
				break;
			
			case 1:
				String number = GetInput.getString("Project Number: ");
				project.setNumber(number);
				break;
			
			case 2:
				String name = GetInput.getString("Project Name: ");
				project.setName(name);
				break;
			
			case 3:
				String building = GetInput.getString("Building Type: ");
				project.setType(building);
				break;
			
			case 4:
				String address = GetInput.getString("Physical Address");
				project.setAddress(address);
			
			case 5:
				String erf = GetInput.getString("Erf Number: ");
				project.setErf(erf);
				break;
			
			case 6:
				Double cost = GetInput.getCost("Project Cost: ");
				project.setCost(cost);
				break;
			
			case 7:
				Double paid = GetInput.getCost("Amount Paid: ");
				project.setPaid(paid);
				break;
			
			case 8:
				LocalDate deadline = GetInput.getDate("Deadline: ");
				project.setDeadline(deadline);
				break;
			
			case 9:
				Person architect = GetInput.getPerson("Architect: ");
				project.setArchitect(architect);
				break;
			
			case 10:
				Person contractor = GetInput.getPerson("Contractor: ");
				project.setContractor(contractor);
				break;
			
			case 11: 
				Person customer = GetInput.getPerson("Customer: ");
				project.setCustomer(customer);
				break;
			
			case 12:
				String finalise = GetInput.getString("Finalise project? (Y/N): ");
				if (finalise.trim().equalsIgnoreCase("y")) {
					project.finalise();
				}
				break;
			
			default: 
				System.out.println("An unknown error occured!");
				break;	
		}
		
		return project;
	}

}
	
