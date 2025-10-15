class Animal {
    public void faireSon() {
        System.out.println("L’animal fait un son.");
    }
}

class Chien extends Animal {
    @Override
    public void faireSon() {
        System.out.println("Le chien aboie !");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Animal monAnimal = new Chien(); // Polymorphisme
        monAnimal.faireSon();           // Le chien aboie !
    }
}
