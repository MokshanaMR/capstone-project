import pytest
from selenium import webdriver

@pytest.fixture(scope="class")
def setup(request):
    """Initialize Chrome WebDriver for the test class."""
    driver = webdriver.Chrome()  # make sure chromedriver is in PATH
    driver.maximize_window()
    request.cls.driver = driver  # attach driver to test class
    yield
    driver.quit()
