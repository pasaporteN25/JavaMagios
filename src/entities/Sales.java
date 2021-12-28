package entities;

public class Sales {
    Integer sales_id;
    Integer customer_id;
    Integer product_id;
    Integer quantity;
    Float total_price;

    public Sales(
            Integer newCustomer_id,
            Integer newProduct_id,
            Integer newQuantity,
            Float newTotal_price
    ){
        customer_id=newCustomer_id;
        product_id=newProduct_id;
        quantity=newQuantity;
        total_price=newTotal_price;
    }

    public Integer getSales_id() {
        return sales_id;
    }

    public void setSales_id(Integer sales_id) {
        this.sales_id = sales_id;
    }

    public Integer getOrder_id() {
        return customer_id;
    }

    public void setOrder_id(Integer order_id) {
        this.customer_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }
}
