package sevenwonders;

public class Wonder {

    public int full; // On fait un max qu'on decremente;
    String name;
    int side;

    /**
     * Incomplet
     */
    public Wonder() {
        side = (Math.random() > 1 / 2) ? 0 : 1;
    }

    public boolean fullWonder() {
        return full == 0;
    }
}
