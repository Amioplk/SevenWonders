package sevenwonders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Frame { // Set à l'aide de fichiers !

    Set<Wonder> wondersAvailable; // Merveilles disponibles
    Object chain; // Chainages (Quel type ?!)
    ArrayList<String> ressources; // Les noms des ressources disponibles
    HashMap<Card, String> typeOfAction; // Type d'action par carte (plusieurs types ?
    // Ex 1piece instant + 1pt à la fin)
    ArrayList<String> LegalTypeOfCards; // Les types de cartes existantes
    ArrayList<Set<Card>> cards; // Créer des cartes à partir des noms...
}
