import java.util.List;

public class ListType {

    private String key;
    private int repeat = 0;
    private List<Integer> distances;

    public ListType(String key, int repeat, List<Integer> distances) {
        this.key = key;
        this.repeat = repeat;
        this.distances = distances;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public void setDistances(List<Integer> distances) {
        this.distances = distances;
    }
}
