package Models;

public class petCreator extends Creator {

    @Override
    protected Pet createNewPet (PetType type) {

        switch (type) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
            case Camel:
                return new Camel();
            case Horse:
                return new Horse();
            case Donkey:
                return new Donkey();
        }
        return null;
    }
}

