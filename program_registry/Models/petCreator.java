package Models;
public class PetCreator extends Creator {

    @Override
    protected Pet createNewPet(Class<? extends Pet> petClass) {
        try {
            return petClass.getDeclaredConstructor().newInstance(); // Создаем новый экземпляр
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Обработка ошибок
        }
    }
}

