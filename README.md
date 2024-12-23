Question: Implement a Spring Boot application that exposes a REST API for managing a list of products and sales.
Requirements:
·   Create a Product class with the following attributes: id, name, description, price, and quantity. Include appropriate constructors, getters, and setters.
·   	Create a ProductService class that contains a list of Product objects. Implement the following methods:
o   getAllProducts(): Returns a list of all products in the service.
o   getProductById(int id): Returns the product with the specified ID.
o   addProduct(Product product): Adds a new product to the service.
o   updateProduct(int id, Product product): Updates the product with the specified ID.
o   deleteProduct(int id): Deletes the product with the specified ID. 
·   	Create a Sale class with the following attributes: id, productId, quantity, and saleDate. Include appropriate constructors, getters, and setters.
·   	Modify the Product class to include a sales attribute, a list of Sale objects.
·   	Modify the ProductService class to include the following methods:
o   getTotalRevenue(): Returns the total revenue generated by all sales.
o   getRevenueByProduct(int productId): Returns the total revenue generated by the specified product.




 
·   	Create a ProductController class that exposes the ProductService methods as a REST API. Use appropriate HTTP methods and status codes for each operation.
·   	Configure the Spring Boot application to use a MySQL database to store the products and sales.
·   	Implement Spring Security to secure the REST API. Only authenticated users with the role of "ADMIN" should be able to add, update, and delete products and sales.
·   	Implement pagination for the getAllProducts method.
·   	Implement exception handling for the REST API. The API should return appropriate error messages and status codes for invalid requests.
·   	In the main method, create a few Product objects and add them to the ProductService. Create a few Sale objects and add them to the SaleService. Demonstrate using the REST API by making HTTP requests to add, update, and delete products and sales. Also, demonstrate the use of the getTotalRevenue and getRevenueByProduct methods to calculate the revenue generated by sales.
