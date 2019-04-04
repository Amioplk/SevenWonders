import java.util.*;



class Rules {
  // On veut ici les regles du jeu pour chaque type d'action

  // Les emprunts chez les autres, savoir s'ils ont ce qu'il faut et si l'argent est suffisant, regarder les eventuelles reductions.
  // La merveille est-elle deja pleine ? -> deja dans Player... Initialisation des merveilles
  // Les coûts des cartes et des ETAGES DE MERVEILLE
  // Ressources liées (questionner le Game qui agit comme une base de données)
  // Si c'est la fin de l'ère ou pas --> endEra dans Game
  // Initialisation d'une partie, distribution des cartes (actions) et des merveilles

  // Chainages
  Object chain;
  // Mappage des merveilles selon les extentions
  HashMap<String, Set<Integer>> wondersAvailable; // --> Game ?
  //Mapping des actions dispos dans les merveilles
  HashMap<String, ArrayList<String>> wonders; // --> Game ?
  //Mapping des actions par nom de carte ?

  static void dealAction(){};

}
