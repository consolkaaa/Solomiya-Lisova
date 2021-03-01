package jsonparsing.dataclasses;

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



}
