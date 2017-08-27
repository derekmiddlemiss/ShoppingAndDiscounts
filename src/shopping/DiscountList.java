package shopping;

import java.util.ArrayList;

public class DiscountList {

    ArrayList< Discount > list;

    public DiscountList(){
        this.list = new ArrayList<>();
    }

    public void addDiscount( Discount discount ){
        this.list.add( discount );
        this.sortListByPrecedence();
    }

    public void removeDiscount( Discount discount ){
        this.list.remove( discount );
    }

    public int getNumberOfDiscounts(){
        return this.list.size();
    }

    public Discount getDiscountAtIndex( int index ) {
        return this.list.get( index );
    }

    public void sortListByPrecedence(){

        Discount holder;
        int length = this.list.size();
        for ( int outer = 1; outer < length; outer++ ) {
            for (int inner = outer; inner > 0; inner--) {

                if (this.list.get( inner ).getPrecedence() < this.list.get( inner - 1 ).getPrecedence()) {
                    holder = this.list.get(inner);
                    this.list.set(inner, this.list.get(inner - 1));
                    this.list.set(inner - 1, holder);
                }

            }
        }
    }

}

