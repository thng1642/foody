package hcmute.edu.vn.foodapp_16;

public class Cart {
    private int image;
    private String nameFood;
    private String quantity;
    private String note;
    private String subTotal;

    public Cart(int image, String nameFood, String quantity, String note, String subTotal){
        this.image = image;
        this.nameFood = nameFood;
        this.quantity = quantity;
        this.note = note;
        this.subTotal = subTotal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }
}
