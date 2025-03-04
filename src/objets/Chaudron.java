package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	
	public boolean restePotion() {
		return quantitePotion!=0;
	}
	public int prendreLouche() {
		this.quantitePotion--;
		if(this.quantitePotion==0) {
			this.forcePotion=0;
		}
		return this.forcePotion;
	}
	public void remplirChaudron(int quantite,int forcePotion) {
		this.quantitePotion=quantite;
		this.forcePotion=forcePotion;
	}
	
}
