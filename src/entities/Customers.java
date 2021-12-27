package entities;

public class Customers {
    Integer customer_id;
    String customer_name;
    String gender;
    Integer age;
    String home_address;
    Integer zip_code;
    String city;
    String state;
    String country;

    public Customers(){}

    public Customers(
            String customer_name,
            String newGender,
            Integer newAge,
            String newHome_address,
            Integer newZip_code,
            String newCity,
            String newState,
            String newCountry
    ){
        //si funciona lo expandimos!
        this.customer_name=customer_name;
        gender=newGender;
        age=newAge;
        home_address=newHome_address;
        zip_code=newZip_code;
        city=newCity;
        state=newState;
        country=newCountry;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public Integer getZip_code() {
        return zip_code;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
