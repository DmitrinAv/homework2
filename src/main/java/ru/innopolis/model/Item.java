package ru.innopolis.model;

/**
 * Модель Item (покупка), составная часть списка покупок
 *
 * Два поля:
 *  @itemId   - id листа покупки
 *  @itemName - наименование товара
 */
public class Item {

    private Integer itemId;
    private String  itemName;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
