# Multithreaded-Selenium-WebDriver-Test-with-TestNG
### Java code to run a Selenium WebDriver test with TestNG using multithreading

#### Description
These code files will be using a mulithreaded approach to run the test in one go
and verifying the hover and click using synchronized block per link on the div header with id "bd" in [AUT](http://www.demo.guru99.com/test/yahoo.html), which is taken from [Guru99](https://www.guru99.com/)

##### Important Notes
<ul>
  <li>In Util.java, there are variables provided to change the setup settings for example: Chrome path,
    URL path for AUT. However, make sure to change chrome path as it varies with user environment.
  </li>
  <li>Can also add firefox path instead of chrome. [Learn more](https://www.guru99.com/first-webdriver-script.html)
  </li>
  <li>If someone wants to try different url for same test case, make sure to change the length of WebElement arrays 
    as per their scenario
  </li>
  <li>If someone wants to try different url for same test case, make sure to change the <strong>length of WebElement arrays</strong>
    , and also the <strong>findElement</strong> method as per their application scenarios.
  </li>
</ul>


##### Steps to run
<ol>
  <li>Create a new TestNG project in Eclipse</li>
  <li>Follow steps from this [tutorial](https://www.guru99.com/all-about-testng-and-selenium.html)</li>
  <li>Create a new package into src folder and name it seleniumtestpackage</li>
  <li>Copy all java files from this folder and import it into your newly created TestNG project/src/seleniumtestpackage</li>
  <li>Build the project</li>
  <li>Run WebsiteTestNGScript.java as normal inside eclipse</li>
</ol>
    
