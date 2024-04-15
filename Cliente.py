class Cliente:
    def __init__(self, id_cliente, nombre, direccion):
        self.id_cliente = id_cliente
        self.nombre = nombre
        self.direccion = direccion

    def get_id(self):
        return self.id_cliente

    def get_nombre(self):
        return self.nombre

    def obtener_informacion(self):
        return f"Id: {self.id_cliente} Nombre: {self.nombre} Dirección: {self.direccion}"

    def es_nombre_igual(self, nombre):
        return self.nombre.lower() == nombre.lower()
