import java.time.LocalDate;

public class ProjectCreator {
	
	private static ProjectCreator instance;

    private ProjectCreator() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static ProjectCreator getInstance() {
    	if (instance == null) {
			instance = new ProjectCreator();
		}
		
		return instance;
    }
    
	public Project createProject() {
        // Gather project details from the user
        String projectNumber = GetInput.getString("Project Number:");
        String projectName = GetInput.getString("Project Name:");
        String buildingType = GetInput.getString("Building Type:");
        String address = GetInput.getString("Project Address:");
        String erfNumber = GetInput.getString("ERF Number:");
        Double totalFee = GetInput.getCost("Total Fee:");
        Double amountPaidToDate = GetInput.getCost("Amount Paid to Date:");
        LocalDate deadline = GetInput.getDate("Deadline:");

        Person architect = GetInput.getPerson("Architect");
        Person contractor = GetInput.getPerson("Contractor");
        Person customer = GetInput.getPerson("Customer");

        Project project = new Project(projectNumber, projectName, buildingType, address, erfNumber,
                totalFee, amountPaidToDate, deadline, architect, contractor, customer);

        System.out.println("Project created!\n");

        return project;
    }

}