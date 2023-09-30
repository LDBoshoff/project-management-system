
public class Menu extends MenuDisplays {
	private static Menu instance;
	private ProjectViewer projectViewer;
	private ProjectCreator projectCreator;
	
	private Menu() {
		projectViewer = ProjectViewer.getInstance();
		projectCreator = ProjectCreator.getInstance();
	}
	
	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		
		return instance;
	}
	
	public void viewProjects(ProjectList projectsList) {
        projectViewer.viewProjects(projectsList);
    }
	
	public Project selectedProject(Project selectedProject) {
		return projectViewer.selectedProject(selectedProject);
	}
	
	public Project createProject() {
        return projectCreator.createProject();
    }
	
}
