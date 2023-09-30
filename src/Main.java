
public class Main {
	public static void main(String[] args) {
	
		ProjectList projectsList = ProjectList.getInstance();
		projectsList.readProjects();
		
		Menu menu = Menu.getInstance();
		menu.printWelcomeMSG();

		int choice = -1;
		
		while (choice != 0) {
			
			System.out.println("Current number of projects: " + projectsList.amountProjects());
			menu.printMenu();	
			choice = GetInput.getIntegerInRange("Enter choice", 0, 3);
			
			switch (choice) {
				
				case 1:
					System.out.println("--------------------------------------------------");
					System.out.println("Creating a new project!");
					Project newProject = menu.createProject();
					newProject.printDetails();
					projectsList.addProject(newProject);
					break;
				
				case 2:
					System.out.println("--------------------------------------------------");
					projectsList.viewAll(); 
					menu.viewProjects(projectsList);
					break;
				
				case 3:	
					String searchInput = GetInput.getString("Enter project number or name to search: ");
					System.out.println("Searching project!\n");
					Project foundProject = projectsList.searchProject(searchInput);
					
					if (foundProject != null) {
						foundProject.printDetails();		    
					    foundProject = menu.selectedProject(foundProject);
					} else {
					    System.out.println("Project not found.\n");
					}

					break;
					
				case 0:
					menu.printExitMSG();
					break;
				
				default:
					System.out.println("Unexpected error occured!\n");
					break;
			}
		}
		
		projectsList.writeProjects();
		GetInput.cleanup();
		System.exit(0);
	}

}