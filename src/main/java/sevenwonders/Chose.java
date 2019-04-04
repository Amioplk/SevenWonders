package sevenwonders;

import java.util.Set;

import sevenwonders.actions.Action;

public interface Chose {

    public Set<Action> getChoices();

    public Action chose();
}
