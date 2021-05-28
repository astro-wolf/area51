package tests.heap;

import org.junit.jupiter.api.Test;
import problems.heap.TripletProduct;

import static org.junit.jupiter.api.Assertions.*;

class TripletProductTest {

    private TripletProduct tripletProduct;

    @Test
    void incremental() {
        tripletProduct = new TripletProduct();
        tripletProduct.findMaxProduct(new int[]{1, 2, 3, 4, 5});
    }


    @Test
    void mixed() {
        tripletProduct = new TripletProduct();
        tripletProduct.findMaxProduct(new int[]{2, 4, 7, 1, 5, 3});
    }

}