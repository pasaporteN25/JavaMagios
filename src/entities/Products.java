package entities;

public class Products {
    Integer product_ID;
    String product_type;
    String product_name;
    String size;
    String colour;
    Float price;
    Integer quantity;
    String description;

    public Products(){}

    public Products(
            String newProduct_type,
            String newProduct_name,
            String newSize,
            String newColour,
            Float newPrice,
            Integer newQuantity,
            String newDescription
    ){
        product_type=newProduct_type;
        product_name=newProduct_name;
        size=newSize;
        colour=newColour;
        price=newPrice;
        quantity=newQuantity;
        description=newDescription;
    }

    public Integer getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
