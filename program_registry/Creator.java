
package Models;

import java.time.LocalDate;

public abstract class Creator {

    protected abstract Pet createNewPet(Class<? extends Pet> petClass);

    public Pet createPet(Class<? extends Pet> petClass, String name, LocalDate date) {
        Pet pet = createNewPet(petClass);
        pet.setName(name);
        pet.setBirthday(date);
        return pet;
    }
}

