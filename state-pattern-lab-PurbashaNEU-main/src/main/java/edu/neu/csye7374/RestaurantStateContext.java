package edu.neu.csye7374;

public class RestaurantStateContext implements RestaurantStateAPI{
    private RestaurantStateAPI lunch;
    private RestaurantStateAPI dinner;
    private RestaurantStateAPI accessory;
    private RestaurantStateAPI optional;
    private RestaurantStateAPI state;

    public RestaurantStateContext(){
        this.lunch = new LunchMenu(this);
        this.dinner = new DinnerMenu(this);
        this.accessory = new Accessory(this);
        this.optional = new OptionalMenu(this);
        this.state = new DinnerMenu(this);
    }
    public RestaurantStateAPI getOptional() {
        optional.optionalMenu();
        return optional;
    }

    public void setOptional(RestaurantStateAPI optional) {
        this.optional = optional;
    }

    public RestaurantStateAPI getLunch() {
        lunch.lunchMenu();
        return lunch;
    }

    public void setLunch(RestaurantStateAPI lunch) {
        this.lunch = lunch;
    }

    public RestaurantStateAPI getDinner() {
        dinner.dinnerMenu();
        return dinner;
    }

    public void setDinner(RestaurantStateAPI dinner) {
        this.dinner = dinner;
    }

    public RestaurantStateAPI getAccessory() {
        accessory.accessoryMode();
        return accessory;
    }

    public void setAccessory(RestaurantStateAPI accessory) {
        this.accessory = accessory;
    }

    public RestaurantStateAPI getState() {
        return state;
    }

    public void setState(RestaurantStateAPI state) {
        this.state = state;
    }


    @Override
    public void lunchMenu() {
    this.state.lunchMenu();
    }

    @Override
    public void accessoryMode() {
this.state.accessoryMode();
    }

    @Override
    public void dinnerMenu() {
this.state.dinnerMenu();
    }

    @Override
    public void optionalMenu() {
this.state.optionalMenu();
    }

}
