import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProjectList {
	
	private static ProjectList instance;
	private ArrayList<Project> projectsList;
	
	private ProjectList() {
		projectsList = new ArrayList<Project>();
	}
	
	public static ProjectList getInstance() {
		if (instance == null) {
			instance = new ProjectList();
		}
		
		return instance;
	}
	
	public void addProject(Project project) {
        projectsList.add(project);
    }

    public void removeProject(Project project) {
        projectsList.remove(project);
    }
    

    public int amountProjects() {
    	return projectsList.size();
    }

    
    public void viewAll() {
    	if (projectsList.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }
        
        System.out.println("All projects:");
        
        for (Project project : projectsList) {
            System.out.println("Project number: " + project.getNumber() + ", name: " + project.getName());
        }
    }
    
    public void viewOngoing() {
    	ArrayList<Project> ongoingProjects = new ArrayList<>();
        
        for (Project project : projectsList) {
            if (!project.getStatus()) {
                ongoingProjects.add(project);
            }
        }
        
        if (ongoingProjects.isEmpty()) {
            System.out.println("All projects have been completed.");
            return;
        }
        
        System.out.println("Ongoing projects:");
        
        for (Project project : ongoingProjects) {
            System.out.println("Project number: " + project.getNumber() + ", name: " + project.getName());
        }
    }
    
    public Project searchProject(String searchInput) {
        for (Project project : projectsList) {  
        	if (project.getNumber().equals(searchInput) || project.getName().equals(searchInput)) {
                return project;
            }
        }
        return null;
    }
    
    public void viewCompleted() {
    	ArrayList<Project> completedProjects = new ArrayList<>();
        
        for (Project project : projectsList) {
            if (project.getStatus()) {
                completedProjects.add(project);
            }
        }
        
        if (completedProjects.isEmpty()) {
            System.out.println("No completed projects.");
            return;
        }
        
        System.out.println("Completed projects:");
        
        for (Project project : completedProjects) {
            System.out.println("Project number: " + project.getNumber() + ", name: " + project.getName());
        }
    }
    
    public void viewOverdue() {
    	ArrayList<Project> overdueProjects = new ArrayList<>();
        
        for (Project project : projectsList) {
            if (project.isOverdue()) {
                overdueProjects.add(project);
            }
        }
        
        if (overdueProjects.isEmpty()) {
            System.out.println("There are currently no overdue projects.");
            return;
        }
        
        System.out.println("Overdue projects:");
        
        for (Project project : overdueProjects) {
            System.out.println("Project number: " + project.getNumber() + ", name: " + project.getName());
        }
    }
 
    
    public void readProjects() {
    	readProjectsFromFile("projects.txt");
    	readProjectsFromFile("completed.txt");
    }
    
    private void readProjectsFromFile(String fileName) {
    	
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
					
			String line;
			while((line = reader.readLine()) != null) {
				
				addProject(fileLineToProject(line));
			}
			
			reader.close();
		
		} catch (IOException e) {
			System.out.println("Could not read from file");
		}

	}
      
    private Project fileLineToProject(String fileLine) {
    	
    	String[] attributes = fileLine.split(",");
		
    	Person architect = new Person(attributes[8], attributes[9], attributes[10], attributes[11], attributes[12]);
		Person contractor = new Person(attributes[13], attributes[14], attributes[15], attributes[16], attributes[17]);
		Person customer = new Person(attributes[18], attributes[19], attributes[20], attributes[21], attributes[22]);
		LocalDate deadline = GetInput.stringToDate(attributes[7]);
		
		Project project = new Project(attributes[0],attributes[1],attributes[2],attributes[3],attributes[4],
				Double.parseDouble(attributes[5]),Double.parseDouble(attributes[6]),
				deadline,architect,contractor,customer);  
        
		if (attributes[23].equals("true")) {
        	project.setStatus(true);
        	String completionDate = attributes[24];
        	project.setCompletionDate(GetInput.stringToDate(completionDate));
        }
		
		return project;
    }
    
    public void writeProjects() {
    	writeProjectsToFile("completed.txt", true);
    	writeProjectsToFile("projects.txt", false);
    }
    
    private void writeProjectsToFile(String fileName, boolean isCompleted) {
	
    	try  (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));){
    					
    		for (int i = 0; i < projectsList.size(); i++) {
				Project p = projectsList.get(i); 
				if (p.getStatus() == isCompleted) {
					writer.write(p.toString() +"\n");
				} 
			}
			
    		writer.close();		
    	} catch (IOException e) {
			System.out.println("Could not write to file");
		}
    }

}
