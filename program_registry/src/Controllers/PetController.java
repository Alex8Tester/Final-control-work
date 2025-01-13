package Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Models.*;
import Services.Repo;
import Services.PetRepo;
import Interfaces.*;

public class PetController {
    private Repo<Pet> petRepo;
    private Creator petCreator;
    private final View<Pet> view;
    private Validator validator;

    public PetController(Repo<Pet> petRepo) {
        this.petRepo = petRepo;
        this.petCreator = new petCreator();
        this.view = new consoleView();
        this.validator = new Validator();
    }

    public void createPet(PetType type) {

        String[] data = new String[] { view.getName(), view.getBirthday() };
        validator.validate(data);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        try {
            int res = petRepo.create(petCreator.createPet(type, data[0], birthday));
            view.showMessage(String.format("%d успешно добавлена", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void updatePet(int id) {

        Pet pet = getById(id);
        String[] data = new String[] { view.getName(), view.getBirthday() };

        validator.validate(data);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        pet.setName(data[0]);
        pet.setBirthday(birthday);
        try {
            int res = petRepo.update(pet);
            view.showMessage(String.format("%d успешно изменена \n", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void getAllPet() {
        try {
            view.printAll(petRepo.getAll(), Pet.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public boolean trainPet(int id, String command) {
        try {

            if (((PetRepo) petRepo).getCommandsById(id, 1).contains(command))
                view.showMessage("я уже умею это");
            else {
                if (!((PetRepo) petRepo).getCommandsById(id, 2).contains(command))
                    view.showMessage("некорректная команда");
                else {
                    ((PetRepo) petRepo).train(id, command);
                    view.showMessage("команда выучена\n");
                    return true;
                }
            }
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }

    public Pet getById(int id) {
        try {
            return petRepo.getById(id);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            petRepo.delete(id);
            view.showMessage("успешно удалено");
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void getCommands(int id) {
        try {
            view.printAll(((PetRepo) petRepo).getCommandsById(id, 1), String.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }
}
