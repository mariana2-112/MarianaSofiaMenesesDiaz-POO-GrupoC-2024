from Producto import Producto

class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, caducidad):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.caducidad = caducidad

    def obtener_informacion_con_caducidad(self):
        return super().obtener_informacion() + " Caducidad: " + self.caducidad

    def get_nombre_producto(self):
        return super().get_nombre()
    
    
