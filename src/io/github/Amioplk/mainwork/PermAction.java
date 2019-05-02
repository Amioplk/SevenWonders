package io.github.Amioplk.mainwork;

public class PermAction extends Action {

  // Les cartes jaunes qui donnent un bonus permanent
  public int many;
  Ressource ressource;
  
  public PermAction(int many, Ressource ressource) {
	  this.many = many;
	  this.ressource = ressource;
  }
	
}