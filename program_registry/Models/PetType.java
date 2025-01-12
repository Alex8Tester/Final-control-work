package Models;
public enum PetType {

    Camel,
    Horse,
    Donkey,
    Hamster,
    Cat,
    Dog;

    public static PetType getType (int typeId){
        switch (typeId) {
            case 1:
                return PetType.Camel;
            case 2:
                return PetType.Horse;
            case 3:
                return PetType.Donkey;
            case 4:
                return PetType.Hamster;
            case 5:
                return PetType.Cat;
            case 6:
                return PetType.Dog;
            default:
                return null;
        }
    }
}
