import os
from datetime import datetime

def capture(driver, test_name):
    project_path = os.getcwd()
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    screenshot_path = os.path.join(project_path, f"screenshots/{test_name}_{timestamp}.png")
    os.makedirs(os.path.dirname(screenshot_path), exist_ok=True)
    driver.save_screenshot(screenshot_path)
    return screenshot_path
