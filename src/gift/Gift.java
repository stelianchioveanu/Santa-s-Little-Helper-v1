package gift;

import enums.Category;

public final class Gift {
    private final String productName;
    private final Double price;
    private final Category category;

    public Gift() {
        this.productName = "";
        this.price = 0.0;
        this.category = Category.BOARD_GAMES;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
