# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
- mainscreen.html, line 14,19: changed to "Crazy Burgers"

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- about.html - created about.html file
- about.html, line 15,16: added button to mainscreen.html
- mainscreen.html, line 21: added button to about.html
- about.html, line 1-5: added html overlay
- about.html, line 6: added title for about
- about.html, line 10: added first header
- about.html, line 22: added second header
- about.html, line 23-40: added info and context about our burger shop
- about.html, line 44: added third header
- about.html, line 45-53: added info about our business and who we are
- about.html, line 57-59: added the footer info
- AboutController - created about controller file
- AboutController, line 7-8: put @Controller and added public class
- AboutController, line 27-28: added @RequestMapping and public class to return about

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
- BootStrapData.java, line 42-45: created if statement to make sure inventory is empty
- BootStrapData.java, line 48-91: added 5 parts
- BootStrapData.java, line 107-120: added 5 products
- BootStrapData.java, sample lines: deleted sample codes that were commented out

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
- mainscreen.html, line 86-88: added a Buy Now button next to update and delete buttons for products, 
pre-mapped to controller, added hidden input field, and set up for POST request
- BuyNowController - created BuyNowController which is related to buy now button
- BuyNowController, line 18-21: added controller annotation and created public class with context private label
- BuyNowController, line 30: added autowired annotation with public BuyNowController class. Added productRepository label.
- BuyNowController, line 27-28: added handling POST request to buy product
- BuyNowController, line 30: Using the ProductRepository to find a product by ID
- BuyNowController, line 32-40: Check if product with given ID exists, if its greater than 0 then we will decrease by 1 and redirect to purchase successful page. 
- BuyNowController, line 41-46: Otherwise we will redirect it to the purchaseError page if the inventory is not available or product is not found.
- BuyNowController, line 50-51: created method to return to purchaseSuccess URL
- BuyNowController, line 55-56: created method to return to purchaseError URL
- purchaseSuccess.html - created html file for purchaseSuccess
- purchaseError.html - created html file for purchaseError
- purchaseSuccess.html, line 1-8: typical html lines with title, head, and doctype
- purchaseError.html, line 1-8: typical html lines with title, head, and doctype
- purchaseSuccess.html, line 10-11: created title and sentence for purchase success
- purchaseError.html, line 10-11: created title and sentence for purchase error
- purchaseSuccess.html, line 12-13: created link to go back to main screen
- purchaseSuccess.html, line 12-13: created link to go back to main screen

- G. Modify the parts to track maximum and minimum inventory by doing the following:
- part.java, line 32-35: added minInv and maxInv fields with @Min annotation
- part.java, line 50-51: added maxInv and minInv to public Part class
- part.java, line 94-106: added maxInv and minInv getter and setter functions
- BootStrapData.java, line 54-55,65-66,76-77,87-88,98-99: added max and min inventory values 
for sample inventory parts
- InhousePartForm.html, line 21-25: added text inputs for both max and min inventory
- OutsourcedPartForm.html, line 21-25: added text inputs for both max and min inventory
- application.properties, line 6: renamed database file name to match
- part.java, line 122-124: created method that checks if inventory is valid, returns true if between max and min values.
Otherwise returns false
- AddInhousePartController, line 32-36: handles submission of form for adding in-house parts. if there are validation
errors then it will return to "InhousePartForm" form.
- AddInhousePartController, line 37-39: if method returns false then we will reject inv field with error message
- AddInhousePartController, line 40-46: Otherwise we will save the part if validation is successful, update products and save part.
- AddOutsourcedPartController, line 36-40: handles submission of form for adding in-house parts. if there are validation
  errors then it will return to "OutsourcedPartForm" form.
- AddOutsourcedPartController, line 41-43: if method returns false then we will reject inv field with error message
- AddOutsourcedPartController, line 44-49: Otherwise we will save the part if validation is successful, update products and save part.
H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
- part.java, line 122: already added from previous section. Have a validation check for if inventory is below minimum or above maximum.
- EnufPartsValidator.java, line 35-62: made if statements that return false to check if any of parts for product would fall
below their minimum if product was made. Updated error message as well.
I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
- PartTest.java, line 161-171: added test for minInv
- PartTest.java, line 174-184: added test for maxInv
J.  Remove the class files for any unused validators in order to clean your code.
