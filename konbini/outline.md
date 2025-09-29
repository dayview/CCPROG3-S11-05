should allow the user to manage a catalog of products available in the store, simulate customer interactions, handle purchases, and track sales

1. inventory & product initialization (maintaining an inventory of various products)
   2. each with attributes such as name, price, quantity in stock, and **category** 
      3. for category, it should indicate which (e.g. food, beverage, toiletries, etc.)
      4. features such as expiration date, brand, or variant (e.g. soda zero, soda light, soda regular) may be included to products when applicable
5. inventory & product management
   6. add new products to the inventory
   7. restock existing items
   8. update product information
9. inventory tracking
   10. dynamic
       11. automatically reducing item quantities after purchases and flagging low-stock items for restocking
       12. system may support perishable goods with expiration tracking (bonus implementation)
13. customer simulation
    14. generating/allowing user input for a customer who selects products to purchase
        15. system should support adding multiple items to a shopping list/cart
            16. viewing the running total
                17. proceed to checkout