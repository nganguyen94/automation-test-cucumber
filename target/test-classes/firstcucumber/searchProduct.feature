Feature: Search product Tiki
  Scenario: Search for products and buy any product
    Given The Tiki page is open
    When The user find product "sửa rửa mặt laneige" and buy any product in list products result
    Then The shopping cart has product selected