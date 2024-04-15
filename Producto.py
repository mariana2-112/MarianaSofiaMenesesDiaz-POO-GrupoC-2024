class Producto:
    CANTIDAD_PRODUCTOS = 0

    def __init__(self, nombre, precio, fecha_importacion, stock):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.stock = stock
        self.numero_serie = Producto.CANTIDAD_PRODUCTOS + 1
        Producto.CANTIDAD_PRODUCTOS += 1

    def agregar_stock(self, cantidad):
        self.stock += cantidad

    def eliminar_stock(self, cantidad):
        if self.validar_stock():
            print("")
        else:
            self.stock -= cantidad

    def validar_stock(self):
        return self.stock == 0

    def obtener_informacion(self):
        return f"Nombre: {self.nombre}, Precio: {self.precio}, Fecha Importación: {self.fecha_importacion}, Stock: {self.stock}, Número de Serie: {self.numero_serie}"

    def get_nombre(self):
        return self.nombre

    def get_precio(self):
        return self.precio

    def get_stock(self):
        return self.stock
