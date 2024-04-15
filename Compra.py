import datetime

class Compra:
    def __init__(self, cliente):
        self.cliente = cliente
        self.productos = []
        self.cantidades = []
        self.total = 0.0

    def agregar_producto(self, producto, cantidad):
        self.productos.append(producto)
        self.cantidades.append(cantidad)
        self.total += producto.precio * cantidad

    def get_total(self):
        return self.total

    def mostrar_detalle_compra(self):
        print(f"Cliente: {self.cliente.get_nombre()}")
        for producto, cantidad in zip(self.productos, self.cantidades):
            print(f"Producto: {producto.get_nombre()} - Cantidad: {cantidad}")
        print(f"Total: ${self.total:.2f}")

    def mostrar_detalle_venta(self):
        detalle = f"Cliente: {self.cliente.get_nombre()}\n"
        for producto, cantidad in zip(self.productos, self.cantidades):
            detalle += f"Producto: {producto.get_nombre()} - Cantidad: {cantidad}\n"
        detalle += f"Total: ${self.total:.2f}\n"
        detalle += f"Fecha de compra: {datetime.date.today()}"
        return detalle
