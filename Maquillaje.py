from Producto import Producto

class Maquillaje(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, color):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.color = color

    def obtener_informacion_con_color(self):
        return f"{super().obtener_informacion()} Color: {self.color}"

    def get_nombre_producto(self):
        return super().get_nombre()
