package com.example.kuba.myapp.result;

public class DataModel {

    private String name;
    private String type;
    private String version_number;
    private String feature;
    private String urlImage;


    public DataModel(String name, String type, String version_number, String feature, String urlImage) {
        this.name = name;
        this.type = type;
        this.version_number = version_number;
        this.feature = feature;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getVersion_number() {
        return version_number;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public String getFeature() {
        return feature;
    }
}
