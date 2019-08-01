package entities;

import java.util.Date;
import java.util.Objects;

public class MyFile {

    private String name;
    private String path;
    private long size;
    private Long dtCreation;

    public MyFile(String name, String path, long size, Long dtCreation) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.dtCreation = dtCreation;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getDtCreation() {
        Date date = new Date(dtCreation);
        return date;
    }

    public long setDtCreation(Long dtCreation) {
        return dtCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyFile)) return false;
        MyFile myFile = (MyFile) o;
        return getPath().equals(myFile.getPath()) &&
                getDtCreation().equals(myFile.getDtCreation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath(), getDtCreation());
    }

    @Override
    public String toString() {
        return name + ", " + path + ", " + size + " Bytes, " + getDtCreation() + "\n";
    }
}
