from Producto import Producto

class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, marca):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.marca = marca

    def obtener_informacion_con_marca(self):
        return f"{super().obtener_informacion()} Marca: {self.marca}"

    def get_nombre_producto(self):
        return super().get_nombre()
