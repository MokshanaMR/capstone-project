from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import pytest
import time


@pytest.fixture(scope="function")
def setup_teardown():
    # Setup driver
    chrome_options = Options()
    chrome_options.add_argument("--start-maximized")
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=chrome_options)
    driver.implicitly_wait(10)

    yield driver  # Run the test

    # Teardown
    driver.quit()


def navigate_url(driver, url):
    driver.get(url)
    time.sleep(2)
