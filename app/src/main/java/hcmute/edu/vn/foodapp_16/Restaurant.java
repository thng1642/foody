package hcmute.edu.vn.foodapp_16;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private int id;
    private int image;
    private String nameRestaurant;
    private String nameFood;
    private String rating;
    public Restaurant(int image, String nameRestaurant, String nameFood, String rating){
        this.image = image;
        this.nameRestaurant = nameRestaurant;
        this.nameFood = nameFood;
        this.rating = rating;
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

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
