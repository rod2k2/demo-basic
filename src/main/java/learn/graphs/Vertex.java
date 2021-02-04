package learn.graphs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Rod ,have fun with coding
 * @date 2021/2/2 21:04
 */
public class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
       return  new HashCodeBuilder(17, 37).
                append(label).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Vertex rhs = (Vertex) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj)).append(label, rhs.label).isEquals();
    }
}
