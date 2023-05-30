import java.util.List;

public class Instructions {
    private final List<String> values;

    public Instructions(List<String> values) {
        this.values = values;
    }


    public List<String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Instructions{" +
                "values=" + values +
                '}';
    }
}
