package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];
        pillars[0] = new Pillar("biodiversidad");
        pillars[1] = new Pillar("agua");
        pillars[2] = new Pillar("tratamiento de basuras");
        pillars[3] = new Pillar("energia");

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     


     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {
        if (pillarType < 0 && pillarType >= pillars.length) {
            return false; 
        }
        Project newProject = new Project(id, name, description, status);
        return pillars[pillarType].registerProject(newProject);
    }
    

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        if (pillarType < 0 && pillarType >= pillars.length) {
            return "pilar no encontrado";
        }
        String projectList = pillars[pillarType].getProjectList();
    
    if (projectList.length() == 0) {
        return projectList;
    }
    return projectList;

    }
}
