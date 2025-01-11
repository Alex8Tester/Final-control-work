package Models;
public enum Home_pet {

    Cat,
    Dog,
    Hamster;

    public static Home_pet getType (int typeHomeId){
        switch (typeHomeId) {
            case 1:
                return Home_pet.Cat;
            case 2:
                return Home_pet.Dog;
            case 3:
                return Home_pet.Hamster;
            default:
                return null;
        }
    }
}

