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

G. Modify the parts to track maximum and minimum inventory by doing the following:

H. Add validation for between or at the maximum and minimum fields. The validation must include the following:

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

J.  Remove the class files for any unused validators in order to clean your code.
