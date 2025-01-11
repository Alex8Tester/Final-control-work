package Models;
public enum Pack_pet {

    Camel,
    Horse,
    Donkey;

    public static Pack_pet getType (int typePackId){
        switch (typePackId) {
            case 1:
                return Pack_pet.Camel;
            case 2:
                return Pack_pet.Horse;
            case 3:
                return Pack_pet.Donkey;
            default:
                return null;
        }
    }
}
