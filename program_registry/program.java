import Controllers.PetController;
import Models.Pet;
import Services.Repo;
import Services.PetRepo;
import Interfaces.consoleMenu;

public class Program {
    public static void main(String[] args) throws Exception {

        Repo <Pet> myFarm = new PetRepo();
        PetController controller = new PetController(myFarm);
        new ConsoleMenu (controller).start();
    }
} 