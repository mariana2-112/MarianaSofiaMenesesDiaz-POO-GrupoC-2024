from Tienda import Tienda

class Sistema:
    CONTRASEÑA = "123"

    def __init__(self):
        self.tienda = Tienda()

    def ejecutarPrograma(self):
        contraseña_valida = False

        while not contraseña_valida:
            print("*** BIENVENIDO ***")
            contraseña = input("INGRESA LA CONTRASEÑA PARA PODER ACCEDER AL SISTEMA: ")

            if self.validar_contraseña(contraseña):
                contraseña_valida = True
                self.mostrar_menu_sistema()
            else:
                print("Contraseña invalida intenta de nuevo.\n")

    def validar_contraseña(self, contraseña):
        return contraseña == self.CONTRASEÑA

    def mostrar_menu_sistema(self):
        opcion = 0

        while opcion != 11:
            print("ELIGE UNA OPCION PARA CONTINUAR")
            print("*** BIENVENIDOS ***")
            print("1.- Agregar cliente")
            print("2.- Agregar producto")
            print("3.- Añadir a stock")
            print("4.- Disminuir Stock")
            print("5.- Listar clientes")
            print("6.- Consultar productos por categoria")
            print("7.- Listar Productos")
            print("8.- Comprar")
            print("9.- Consultar compras")
            print("10.- Eliminar productos y clientes")
            print("11. Salir")

            opcion = int(input("Ingresa la opcion: "))

            if opcion == 1:
                self.tienda.registrar_cliente()
            elif opcion == 2:
                self.tienda.registrar_producto()
            elif opcion == 3:
                print("Ingresa el tipo de producto al que le deseas añadir stock:")
                print("1.- Limpieza")
                print("2.- Electrodomesticos")
                print("3.- Alimento")
                print("4.- Maquillaje")
                opcion_producto_añadir_stock = int(input("Ingresa la opción: "))

                if opcion_producto_añadir_stock == 1:
                    self.tienda.añadir_stock_limpieza()
                elif opcion_producto_añadir_stock == 2:
                    self.tienda.añadir_stock_electrodomestico()
                elif opcion_producto_añadir_stock == 3:
                    self.tienda.añadir_stock_alimento()
                elif opcion_producto_añadir_stock == 4:
                    self.tienda.añadir_stock_maquillaje()
                else:
                    print("Opción no válida.")
            elif opcion == 4:
                print("Ingresa el tipo de producto al que le deseas eliminar stock:")
                print("1.- Limpieza")
                print("2.- Electrodomesticos")
                print("3.- Alimento")
                print("4.- Maquillaje")
                opcion_producto_eliminar_stock = int(input("Ingresa la opción: "))

                if opcion_producto_eliminar_stock == 1:
                    self.tienda.disminuir_stock_limpieza()
                elif opcion_producto_eliminar_stock == 2:
                    self.tienda.disminuir_stock_electrodomestico()
                elif opcion_producto_eliminar_stock == 3:
                    self.tienda.disminuir_stock_alimento()
                elif opcion_producto_eliminar_stock == 4:
                    self.tienda.disminuir_stock_maquillaje()
                else:
                    print("Opción no válida.")
            elif opcion == 5:
                self.tienda.consultar_clientes()
            elif opcion == 6:
                print("Ingresa el tipo de producto que deseas consultar:")
                print("1.- Limpieza")
                print("2.- Electrodomesticos")
                print("3.- Alimento")
                print("4.- Maquillaje")
                opcion_producto_consulta = int(input("Ingresa la opción: "))

                if opcion_producto_consulta == 1:
                    self.tienda.consultar_productos_limpieza()
                elif opcion_producto_consulta == 2:
                    self.tienda.consultar_productos_electrodomestico()
                elif opcion_producto_consulta == 3:
                    self.tienda.consultar_productos_alimento()
                elif opcion_producto_consulta == 4:
                    self.tienda.consultar_productos_maquillaje()
                else:
                    print("Opción no válida.")
            elif opcion == 7:
                self.tienda.consultar_productos()
            elif opcion == 8:
                self.tienda.realizar_compra()
            elif opcion == 9:
                self.tienda.consultar_compras()
            elif opcion == 10:
                print("ELIMINAR OPCIONES")
                print("1.- Eliminar cliente")
                print("2.- Eliminar producto")
                print("3.- Regresar al menú principal")
                opcionEliminar = int(input("Ingresa la opcion: "))
                if opcionEliminar == 1:
                    self.tienda.eliminar_cliente()
                elif opcionEliminar == 2:
                    self.tienda.eliminar_producto()
                elif opcionEliminar == 3:
                    pass
                else:
                    print("Opción no válida.")
            elif opcion == 11:
                print("Saliendo")
            else:
                print("INGRESE UNA OPCIÓN VALIDA")
