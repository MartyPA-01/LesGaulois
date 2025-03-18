package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;	
	private Chaudron chaudron;

	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		this.chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		boolean contientPotion = this.chaudron.restePotion();
		String nomGaulois = gaulois.getNom();
		if (contientPotion) {
			if ("Obélix".equals(nomGaulois) || "Obelix".equals(nomGaulois)) {
				parler("Non, " + nomGaulois + ", Non !... Et tu le sais très bien");
			} else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				this.parler("Tiens " + nomGaulois + ", un peu de potion magique.");
			}
		} else {
			this.parler("Désolé " + nomGaulois + ", il n'y a plus une seule goutte de potion.");
		}
	}
}
