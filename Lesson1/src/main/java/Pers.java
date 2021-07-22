import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Pers implements Cloneable {
    String name = "ppp";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
