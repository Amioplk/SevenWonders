package main.java.io.github.Amioplk.mainwork;

class BorrowAction extends Action implements Applyable {

  int many;
  Ressource what;
  private Player who;
  
  public BorrowAction(Ressource r, int need) {
	  this.what = r;
	  this.many = need;
  }
  
  @Override
  public void apply() {
	
	Player lNeighbour = game.getNeighbour(user, false);
	Player rNeighbour = game.getNeighbour(user, true);
		
	boolean left = lNeighbour.getTotalRessources(what) >= 0;
	boolean right = rNeighbour.getTotalRessources(what) >= 0;
	
	if(left && right) {
		// Choose player
	}
	else if(left && lNeighbour.getTotalRessources(what) >= many) {
		
		lNeighbour.addMoney(many*user.priceLeft);
		user.addMoney(-many*user.priceLeft);
	}
	else if(right && rNeighbour.getTotalRessources(what) >= many) {
			
		rNeighbour.addMoney(many*user.priceRight);
		user.addMoney(-many*user.priceRight);
			
	}
	else; //C'est la merde

	  
  }

  public Player getWho() {
	return who;
  }

  public void setWho(Player who) {
	this.who = who;
  }
  
  

}