from Producto import Producto

class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, voltaje):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.voltaje = voltaje

    def obtener_informacion_con_voltaje(self):
        return f"{super().obtener_informacion()} Voltaje: {self.voltaje}"

    def get_nombre_producto(self):
        return super().get_nombre()
