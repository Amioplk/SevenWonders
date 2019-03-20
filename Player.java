import java.util.*;



class Player {
  //La classe Player doit lancer des Actions !!

  String name;
  // Les cartes de ressources(+military) + les cartes déjà posées
  HashMap<String, Integer> ressources; //Ne doit-on pas garder plutôt le nom des cartes posées ?
  // Etat des merveilles
  int full; // On fait un max qu'on décrémente
  // Nom de la merveilles
  String wonder; //Faire une classe Wonder ? --> enmène full avec lui  --> fullWonder à modifier
  // Les cartes en main (ne pas faire de LinkedList !)
  LinkedList<String> hand; // Les cartes sont des Strings et on crée des actions dans les règles

  public Player(String name){
    this.name = name;
  }

  boolean fullWonder() {
    if(this.full == 0){
      return true;
    }
    else{
      return false;
    }
  }

  Action use(){return}; //return Action ?

  }
