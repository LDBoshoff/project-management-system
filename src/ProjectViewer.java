
public class ProjectViewer {
	
	private static ProjectViewer instance;
	private ProjectUpdater projectUpdater;

	
	private ProjectViewer() {
		projectUpdater = ProjectUpdater.getInstance();
	}

	public static ProjectViewer getInstance() {
		if (instance == null) {
			instance = new ProjectViewer();
		}
		
		return instance;
		
	}
	
	private void viewOptions() {
		System.out.println("--------------------------------------------------");
		System.out.println("1) Select a project");
        System.out.println("2) View ongoing projects");
        System.out.println("3) View completed projects");
        System.out.println("4) View overdue projects");
        System.out.println("0) Go back to main menu\n");
	}
	
	public void viewProjects(ProjectList projectsList) {
        int viewChoice = -1;

        while (viewChoice != 0) {
        	viewOptions();
            viewChoice = GetInput.getIntegerInRange("Enter choice", 0, 4);

            switch (viewChoice) {
                
            	case 1:
            		System.out.println("Select a project");
            		String searchInput = GetInput.getString("Enter project number or name: ");
					Project foundProject = projectsList.searchProject(searchInput);
					
					if (foundProject != null) {	
						System.out.println("--------------------------------------------------");
						foundProject.printDetails();
						System.out.println("--------------------------------------------------");
					    foundProject = selectedProject(foundProject);
					
					} else {
					    System.out.println("Project not found!");
					}

					break;
                
            	case 2:
					System.out.println("--------------------------------------------------");
            		projectsList.viewOngoing();// Case 2 prints ongoing projects number and names currently in the list of projects
                    break;
                
            	case 3:
					System.out.println("--------------------------------------------------");
            		projectsList.viewCompleted();// Case 3 prints completed projects number and names currently in the list of projects
                    break;
                
            	case 4:
					System.out.println("--------------------------------------------------");
            		projectsList.viewOverdue();// Case 4 prints overdue projects number and names currently in the list of projects
                    break;
                
            	case 0:
                    System.out.println("Exiting back to the main menu!\n");
                    break;
                
            	default:
                    System.out.println("Invalid choice\n");
                    break;
            }
        }
    }
	
	public Project selectedProject(Project project) {
		boolean continueLoop = true;
        
	    while (continueLoop) {
	    	System.out.println("1) Update project");
	    	System.out.println("0) Go back\n");
            int subChoice = GetInput.getIntegerInRange("Enter choice", 0, 1);

            switch (subChoice) {
                case 1:
                    project = updateProject(project);
                    break;
                case 0:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("An unknown error occured!");
                    break;
            }
        }
	    
	    return project;
	}
	
	private Project updateProject(Project projectToUpdate) {
		return projectUpdater.updateAttribute(projectToUpdate);
	}
}


