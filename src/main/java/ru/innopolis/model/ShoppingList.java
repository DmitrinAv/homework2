package ru.innopolis.model;

/**
 * Модель Shopping List (список покупок)
 *
 * Два поля:
 *  @shoppingListId   - id листа покупок
 *  @shoppingListName - имя листа покупок
 */
public class ShoppingList {

    private Integer shoppingListId;
    private String  shoppingListName;

    public Integer getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }
}
