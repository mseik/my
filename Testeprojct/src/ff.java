public class ff implements  Comparable<ff>{
    private  Integer ds;

public Integer getDs() {
    return ds;
}

public void setDs(Integer ds) {
    this.ds = ds;
}

@Override
public String toString() {
    return "ff{" +
        "ds=" + ds +
        '}';
}

@Override
public int compareTo(ff o) {
    return this.ds-o.getDs()>0 ? 1 : -1;
}
}
