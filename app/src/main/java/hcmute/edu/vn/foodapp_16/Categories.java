package hcmute.edu.vn.foodapp_16;

import java.io.Serializable;

public class Categories implements Serializable {
    private int id;
    private int image;
    private String categories;

    public Categories(int image, String categories) {
        this.image = image;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
