package shopping;

import java.util.ArrayList;

public class ShoppingBasket {

    ArrayList<Item> basket;
    Boolean loyaltyCard;

    public ShoppingBasket(){
        this.basket = new ArrayList<>();
        this.loyaltyCard = false;
    }

    public ArrayList<Item> getBasket() {
        return this.basket;
    }

    public Boolean getLoyaltyCard() {
        return this.loyaltyCard;
    }

    public void customerHasLoyaltyCard(){
        this.loyaltyCard = true;
    }

    public void addItemToBasket( Item item ){
        this.basket.add( item );
    }

    public void removeItemFromBasket( Item item ){
        this.basket.remove( item );
    }

    public int getNumberItemsInBasket(){
        return this.basket.size();
    }

    public void removeAllItemsFromBasket(){
        for ( Item item : basket ){
            this.basket.remove( item );
        }
    }

}
