package hcmute.edu.vn.foodapp_16;

public class Order {
    private int image;
    private String nameFood;
    private String quantity;
    private String total;
    private String status;
    public Order(int image, String nameFood, String quantity,String total, String status){
        this.image = image;
        this.nameFood = nameFood;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
