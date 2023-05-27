package every2096;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Fragment {
    private final String ids = UUID.randomUUID().toString().substring(0, 10);
    public Fragment parent = null;
    public List<String> words = new ArrayList<>();

    public List<String> children = new ArrayList<>();

    public void setParent(Fragment parent) {
        this.parent = parent;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }


    public Fragment getParent() {
        return parent;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public String getIds() {
        return ids;
    }
}
