package Village;

import personnages.Gaulois;

public class Village {
    private String nom;
    private Gaulois chef;
    private Gaulois[] villageois;
    private int nbVillageois = 0;

    public Village(String nom, Gaulois chef, int maxHabitants) {
        this.nom = nom;
        this.chef = chef;
        chef.setVillage(this);
        this.villageois = new Gaulois[maxHabitants];
    }

    public String getNom() {
        return nom;
    }

    public Gaulois getChef() {
        return chef;
    }

    public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            gaulois.setVillage(this);
            nbVillageois++;
        }
        else {
        	System.out.println("Le village est plein");
        }
    }

    public Gaulois trouverVillageois(int numero) {
        if (numero > 0 && numero <= nbVillageois) {
            return villageois[numero - 1];
        }
        System.out.println("Il n’y a pas autant d’habitants dans notre village !");
        return null;
    }

    public void afficherVillageois() {
        System.out.println("Dans le village \"" + nom + "\" du chef " + chef);
        System.out.println("vivent les légendaires gaulois :");
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i]);
        }
    }
    
    
    public static void main(String[] args) {
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
        Village village = new Village("Village des Irréductibles", abraracourcix, 30);

        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterVillageois(asterix);
        System.out.println(village.trouverVillageois(1));
        System.out.println(village.trouverVillageois(2));

        village.afficherVillageois();

        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterVillageois(obelix);
        village.afficherVillageois();

        Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
        System.out.println(abraracourcix.sePresenter());
        System.out.println(asterix.sePresenter());
        System.out.println(doublepolemix.sePresenter());
    }

}

