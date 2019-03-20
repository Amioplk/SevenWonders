class Rules {
  // On veut ici les regles du jeu pour chaque type d'action

  // Les emprunts chez les autres, savoir s'ils ont ce qu'il faut et si l'argent est suffisant, regarder les eventuelles reductions.
  // La merveille est-elle deja pleine ? Initialisation des merveilles
  // Les coûts des cartes et des étages de merveille
  // Les verifications pour les chainages
  // Ressources liées (questionner le Game qui agit comme une base de données)
  // Si c'est la fin de l'ère ou pas --> endEra dans Game
  // Initialisation d'une partie, distribution des cartes (actions) et des merveilles
  // Pas deux cartes de même nom
  // Chainages

  void dealActions();

  boolean doesChain(); // Faire une structure speciale ?? Oui je pense

  // Verifications de coûts (en checkant les chainages)
  boolean freeCost();

  void drawWonders(); // Dans Game ?

  BorrowedAction toBorrow();

  private boolean checkNeighbours();

}
