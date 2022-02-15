public class Dice {
    // Propriétés
    private final int sideNumber;

    public Dice(int sideNumber) { // Constructeur -> pas de type de retour et porte le nom de la classe
        this.sideNumber = sideNumber;
    }

    public int roll() {
        double random = Math.random(); // Math.random() retourne un nombre entre 0 et 1 (double)
        int MAX = this.sideNumber, MIN = 1;
        return (int)Math.floor(random*(MAX-MIN+1)+MIN);
    }

    public int getSideNumber() {
        return sideNumber;
    }
}
