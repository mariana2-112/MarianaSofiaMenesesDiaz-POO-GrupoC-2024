from Cliente import Cliente
from Maquillaje import Maquillaje
from Limpieza import Limpieza
from Alimento import Alimento
from Electrodomestico import Electrodomestico
from Compra import Compra
import random

class Tienda:
    def __init__(self):
        self.clientes = []
        self.productos_maquillaje = []
        self.productos_limpieza = []
        self.productos_alimento = []
        self.productos_electrodomestico = []
        self.compras_realizadas = []
        self.random = random.Random()

    # Métodos de registro de clientes y productos

    def registrar_cliente(self):
        id_cliente = self.validar_id_cliente()
        nombre = input("Ingresa el nombre: ")
        direccion = input("Ingresa la dirección: ")

        cliente = Cliente(id_cliente, nombre, direccion)
        self.clientes.append(cliente)
        print("¡Cliente registrado con éxito!")

    def consultar_clientes(self):
        print("*** CLIENTES ***")
        for cliente in self.clientes:
            print(cliente.obtener_informacion())

    def validar_id_cliente(self):
        while True:
            id_cliente = self.random.randint(1, 1000)
            if not any(cliente.id == id_cliente for cliente in self.clientes):
                return id_cliente   

    def registrar_producto(self):
        print("Selecciona la categoría del producto a registrar:")
        print("1. Limpieza")
        print("2. Electrodoméstico")
        print("3. Alimento")
        print("4. Maquillaje")
    
        opcion_categoria = int(input("Ingresa la opción: "))
    
        if opcion_categoria == 1:
            self.registrar_producto_limpieza()
        elif opcion_categoria == 2:
            self.registrar_producto_electrodomestico()
        elif opcion_categoria == 3:
            self.registrar_productos_alimento()
        elif opcion_categoria == 4:
            self.registrar_productos_maquillaje()
        else:
            print("Opción no válida.")
              
    def registrar_producto_limpieza(self):
        print("\n *** Elegiste registrar un producto de la categoría limpieza ***")
        datos = self.registrar_datos_comun()

        marca = input("Ingresa la marca: ")
        limpieza = Limpieza(datos[0], float(datos[1]), datos[2], int(datos[3]), marca)
        self.productos_limpieza.append(limpieza)

    def consultar_productos_limpieza(self):
        print("*** PRODUCTOS LIMPIEZA ***")
        for producto in self.productos_limpieza:
            print(producto.obtener_informacion_con_marca())

    def añadir_stock_limpieza(self):
        self.consultar_productos_limpieza()
        nombre_producto = input("Ingresa el nombre del producto de limpieza al que deseas añadir stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas añadir: "))

        for producto in self.productos_limpieza:
            if producto.get_nombre() == nombre_producto:
                producto.agregar_stock(cantidad)
                print("Stock añadido")
                return
        print("Producto no encontrado.")

    def disminuir_stock_limpieza(self):
        self.consultar_productos_limpieza()
        nombre_producto = input("Ingresa el nombre del producto de limpieza al que deseas eliminar stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas eliminar: "))

        for producto in self.productos_limpieza:
            if producto.get_nombre() == nombre_producto:
                producto.eliminar_stock(cantidad)
                print("Stock eliminado")
                return
        print("Producto no encontrado.")

    def registrar_producto_electrodomestico(self):
        print("\n *** Elegiste registrar un producto de la categoría Electrodoméstico ***")
        datos = self.registrar_datos_comun()

        voltaje = input("Ingresa el voltaje: ")
        electrodomestico = Electrodomestico(datos[0], float(datos[1]), datos[2], int(datos[3]), voltaje)
        self.productos_electrodomestico.append(electrodomestico)

    def consultar_productos_electrodomestico(self):
        print("*** PRODUCTOS ELECTRODOMÉSTICO ***")
        for producto in self.productos_electrodomestico:
            print(producto.obtener_informacion_con_voltaje())

    def añadir_stock_electrodomestico(self):
        self.consultar_productos_electrodomestico()
        nombre_producto = input("Ingresa el nombre del electrodoméstico al que deseas añadir stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas añadir: "))

        for producto in self.productos_electrodomestico:
            if producto.get_nombre() == nombre_producto:
                producto.agregar_stock(cantidad)
                print("Stock añadido")
                return
        print("Producto no encontrado.")

    def disminuir_stock_electrodomestico(self):
        self.consultar_productos_electrodomestico()
        nombre_producto = input("Ingresa el nombre del electrodoméstico al que deseas eliminar stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas eliminar: "))

        for producto in self.productos_electrodomestico:
            if producto.get_nombre() == nombre_producto:
                producto.eliminar_stock(cantidad)
                print("Stock eliminado")
                return
        print("Producto no encontrado.")

    def registrar_productos_alimento(self):
        print("\n *** Elegiste registrar un producto de la categoría Alimento ***")
        datos = self.registrar_datos_comun()

        caducidad = input("Ingresa la caducidad: ")
        alimento = Alimento(datos[0], float(datos[1]), datos[2], int(datos[3]), caducidad)
        self.productos_alimento.append(alimento)

    def consultar_productos_alimento(self):
        print("*** PRODUCTOS ALIMENTOS ***")
        for producto in self.productos_alimento:
            print(producto.obtener_informacion_con_caducidad())

    def añadir_stock_alimento(self):
        self.consultar_productos_alimento()
        nombre_producto = input("Ingresa el nombre del alimento al que deseas añadir stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas añadir: "))

        for producto in self.productos_alimento:
            if producto.get_nombre() == nombre_producto:
                producto.agregar_stock(cantidad)
                print("Stock añadido")
                return
        print("Producto no encontrado.")

    def disminuir_stock_alimento(self):
        self.consultar_productos_alimento()
        nombre_producto = input("Ingresa el nombre del alimento al que deseas eliminar stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas eliminar: "))

        for producto in self.productos_alimento:
            if producto.get_nombre() == nombre_producto:
                producto.eliminar_stock(cantidad)
                print("Stock eliminado")
                return
        print("Producto no encontrado.")

    def registrar_productos_maquillaje(self):
        print("\n *** Elegiste registrar un producto de la categoría Maquillaje ***")
        datos = self.registrar_datos_comun()

        color = input("Ingresa el color: ")
        maquillaje = Maquillaje(datos[0], float(datos[1]), datos[2], int(datos[3]), color)
        self.productos_maquillaje.append(maquillaje)

    def consultar_productos_maquillaje(self):
        print("*** PRODUCTOS MAQUILLAJE ***")
        for producto in self.productos_maquillaje:
            print(producto.obtener_informacion_con_color())

    def añadir_stock_maquillaje(self):
        self.consultar_productos_maquillaje()
        nombre_producto = input("Ingresa el nombre del maquillaje al que deseas añadir stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas añadir: "))

        for producto in self.productos_maquillaje:
            if producto.get_nombre() == nombre_producto:
                producto.agregar_stock(cantidad)
                print("Stock añadido")
                return
        print("Producto no encontrado.")

    def disminuir_stock_maquillaje(self):
        self.consultar_productos_maquillaje()
        nombre_producto = input("Ingresa el nombre del maquillaje al que deseas eliminar stock: ")
        cantidad = int(input("Ingresa la cantidad de stock que deseas eliminar: "))

        for producto in self.productos_maquillaje:
            if producto.get_nombre() == nombre_producto:
                producto.eliminar_stock(cantidad)
                print("Stock eliminado")
                return
        print("Producto no encontrado.")

    def consultar_productos(self):
        self.consultar_productos_limpieza()
        self.consultar_productos_electrodomestico()
        self.consultar_productos_alimento()
        self.consultar_productos_maquillaje()

    def registrar_datos_comun(self):
        datos = []
        nombre = input("Ingresa un nombre: ")
        datos.append(nombre)

        precio = float(input("Ingresa el precio: "))
        datos.append(precio)

        fecha = input("Ingresa la fecha de importación: ")
        datos.append(fecha)

        stock = int(input("Ingresa el stock del producto: "))
        datos.append(stock)

        return datos

    def realizar_compra(self):
        nombre_cliente = input("Ingresa el nombre del cliente: ")
        cliente = self.buscar_cliente_por_nombre(nombre_cliente)

        if not cliente:
            print("Cliente no registrado. Debes registrarte antes de realizar una compra.")
            return

        self.consultar_productos()

        nombre_producto = input("Ingresa el nombre del producto que deseas comprar: ")
        producto = self.buscar_producto_por_nombre(nombre_producto)

        if not producto:
            print("Producto no encontrado.")
            return

        cantidad = int(input("Ingresa la cantidad que deseas comprar: "))

        if producto.get_stock() < cantidad:
            print("No hay suficiente stock disponible.")
            return

        compra = Compra(cliente)
        compra.agregar_producto(producto, cantidad)
        
        # Actualizar el stock del producto después de la compra
        producto.eliminar_stock(cantidad)

        print("Compra realizada con éxito:")
        compra.mostrar_detalle_compra()
        self.registrar_compra(compra)

    def buscar_cliente_por_nombre(self, nombre):
        for cliente in self.clientes:
            if cliente.nombre == nombre:
                return cliente
        return None

    def buscar_producto_por_nombre(self, nombre):
        for producto in self.productos_limpieza + self.productos_electrodomestico + self.productos_alimento + self.productos_maquillaje:
            if producto.get_nombre() == nombre:
                return producto
        return None

    def registrar_compra(self, compra):
        self.compras_realizadas.append(compra)
        print("Compra registrada con éxito.")

    def consultar_compras(self):
        print("*** COMPRAS REALIZADAS ***")
        for compra in self.compras_realizadas:
            compra.mostrar_detalle_compra()
            print("--------------")

    def eliminar_cliente(self):
        self.consultar_clientes()
        print("Ingresa el nombre del cliente que deseas eliminar: ")
        nombre_cliente = input()
        
        cliente = self.buscar_cliente_por_nombre(nombre_cliente)
        
        if not cliente:
            print("Cliente no registrado.")
            return
        
        if self.tiene_compras_asociadas(cliente=cliente):
            print("El cliente tiene compras asociadas y no puede ser eliminado.")
            return
        
        self.clientes.remove(cliente)
        print("Cliente eliminado con éxito.")

    def eliminar_producto(self):
        self.consultar_productos()
        print("Ingresa el nombre del producto que deseas eliminar: ")
        
        nombre_producto = input()
        
        producto = None
        
        for prod in self.productos_limpieza:
            if prod.get_nombre() == nombre_producto:
                producto = prod
                break

        if not producto:
            for prod in self.productos_electrodomestico:
                if prod.get_nombre() == nombre_producto:
                    producto = prod
                    break

        if not producto:
            for prod in self.productos_alimento:
                if prod.get_nombre() == nombre_producto:
                    producto = prod
                    break

        if not producto:
            for prod in self.productos_maquillaje:
                if prod.get_nombre() == nombre_producto:
                    producto = prod
                    break

        if not producto:
            print("Producto no encontrado.")
            return

        # Verificar si el producto está vinculado a alguna compra
        if self.tiene_compras_asociadas(producto=producto):
            print("El producto está vinculado a una compra y no puede ser eliminado.")
            return

        # Eliminar el producto
        if producto in self.productos_limpieza:
            self.productos_limpieza.remove(producto)
        elif producto in self.productos_electrodomestico:
            self.productos_electrodomestico.remove(producto)
        elif producto in self.productos_alimento:
            self.productos_alimento.remove(producto)
        elif producto in self.productos_maquillaje:
            self.productos_maquillaje.remove(producto)

        print("Producto eliminado con éxito.")

    def tiene_compras_asociadas(self, cliente=None, producto=None):
        if cliente:
            for compra in self.compras_realizadas:
                if compra.cliente == cliente:
                    return True
        elif producto:
            for compra in self.compras_realizadas:
                if producto in compra.productos:
                    return True
        return False
