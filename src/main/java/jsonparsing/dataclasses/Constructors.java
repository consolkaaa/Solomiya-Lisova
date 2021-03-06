package jsonparsing.dataclasses;

import java.util.Objects;

public class Constructors {

    private String constructorId;
    private String url;
    private String name;
    private String nationality;

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "{"
                + "constructorId=\'" + constructorId + "\', "
                + "url=\'" + url + "\', "
                + "name=\'" + name + "\', "
                + "nationality=\'" + nationality + "\'"
                + "}";
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        Constructors constructors = (Constructors) obj;

        if (this.getName().equals(constructors.getName())
            & this.getUrl().equals(constructors.getUrl())
            & this.getConstructorId().equals(constructors.getConstructorId())
            & this.getNationality().equals(constructors.getNationality())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(constructorId, name, url, nationality);
    }

}
