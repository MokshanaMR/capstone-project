from selenium.webdriver.common.by import By

class LoginPage:
    def __init__(self, driver):
        self.driver = driver
        self.username = (By.NAME, "username")
        self.password = (By.NAME, "password")
        self.submit_button = (By.XPATH, "//button[@type='submit']")
        self.dashboard = (By.XPATH, "//h6[text()='Dashboard']")

    def enter_username(self, username):
        self.driver.find_element(*self.username).send_keys(username)

    def enter_password(self, password):
        self.driver.find_element(*self.password).send_keys(password)

    def click_submit(self):
        self.driver.find_element(*self.submit_button).click()

    def is_dashboard_displayed(self):
        return self.driver.find_element(*self.dashboard).is_displayed()
