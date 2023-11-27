
# 8. Reimplement the class of the preceding exercise in Java, 
# JavaScript, Python, C#, or C++ (your choice). How much shorter 
# is the Scala class?

class Car:

    def __init__(self, manufacturer, model_name, model_year = None, license_plate = None):
        self.manufacturer = manufacturer
        self.model_name = model_name
        self.model_year = model_year if model_year else -1
        self.license_plate = license_plate if license_plate else ''


if __name__ == '__main__':

    c1 = Car(manufacturer='Ford', model_name='F-150')
    c2 = Car(manufacturer='KIA', model_name='Sorento', model_year=2015)
    c3 = Car(manufacturer='Honda', model_name='Civic', license_plate='HSL2323')
    c4 = Car('Tesla', 'M3', 2023, 'GB7SD8')

    assert c1.model_year == -1
    assert c2.license_plate == ''
    assert c3.model_year == -1