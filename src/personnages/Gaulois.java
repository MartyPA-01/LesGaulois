package personnages;

import Village.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;
    private Village village;


	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
    public String sePresenter() {
        if (village == null) {
            return "Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.\"";
        } else if (village.getChef() == this) {
            return "Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".\"";
        } else {
            return "Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".\"";
        }
    }
    
    public void setVillage(Village village) {
        this.village = village;
    }

	public String getNom(){
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force * effetPotion / 3);
		if(effetPotion> 1) {
			effetPotion--;
		}
	}

	@Override
	public String toString() {
		return nom;
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;		
	}
}