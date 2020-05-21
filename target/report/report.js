$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/firstcucumber/searchProduct.feature");
formatter.feature({
  "name": "Search product Tiki",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search for products and buy any product",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The Tiki page is open",
  "keyword": "Given "
});
formatter.match({
  "location": "firstcucumber.StepDefinitions.the_Tiki_page_is_open()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user find product \"sửa rửa mặt laneige\" and buy any product in list products result",
  "keyword": "When "
});
formatter.match({
  "location": "firstcucumber.StepDefinitions.the_user_find_product_productName_and_buy_any_product_in_list_products_result(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The shopping cart has product selected",
  "keyword": "Then "
});
formatter.match({
  "location": "firstcucumber.StepDefinitions.the_shopping_cart_has_product_productName()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});