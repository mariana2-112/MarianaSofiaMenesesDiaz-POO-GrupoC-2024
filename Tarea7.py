class Empleado:
    def __init__(self, nombre):
        self.nombre = nombre
        self.cuentas = []

    def agregar_cuenta(self, numero_cuenta, tipo_cuenta):
        self.cuentas.append(CuentaBancaria(numero_cuenta, tipo_cuenta))

    def obtener_nombre(self):
        return self.nombre

    def buscar_cuenta(self, numero_cuenta):
        for cuenta in self.cuentas:
            if cuenta.obtener_numero_cuenta() == numero_cuenta:
                return cuenta
        return None

    def mostrar_informacion(self):
        print("Nombre del empleado:", self.nombre)
        print("Cuentas:")
        for cuenta in self.cuentas:
            cuenta.mostrar_informacion()
            print()


class CuentaBancaria:
    def __init__(self, numero_cuenta, tipo_cuenta):
        self.numero_cuenta = numero_cuenta
        self.tipo_cuenta = tipo_cuenta
        self.saldo = 0

    def obtener_numero_cuenta(self):
        return self.numero_cuenta

    def obtener_tipo_cuenta(self):
        return self.tipo_cuenta

    def depositar(self, cantidad):
        self.saldo += cantidad
        print("Se realizó el depósito. Nuevo saldo:", self.saldo)

    def retirar(self, cantidad):
        if self.saldo - cantidad >= self.obtener_saldo_minimo():
            self.saldo -= cantidad
            print("Se realizó el retiro. Nuevo saldo:", self.saldo)
        else:
            print("Saldo insuficiente")

    def obtener_saldo_minimo(self):
        if self.tipo_cuenta == 'A':
            return 1000
        elif self.tipo_cuenta == 'B':
            return 5000
        elif self.tipo_cuenta == 'C':
            return 10000
        else:
            return 0

    def mostrar_informacion(self):
        print("Número de cuenta:", self.numero_cuenta)
        print("Tipo de cuenta:", self.tipo_cuenta)
        print("Saldo:", self.saldo)


class Banco:
    def __init__(self):
        self.empleados = []

    def agregar_empleado(self, nombre):
        self.empleados.append(Empleado(nombre))

    def buscar_empleado(self, nombre):
        for empleado in self.empleados:
            if empleado.obtener_nombre() == nombre:
                return empleado
        return None

    def buscar_cuenta(self, numero_cuenta):
        for empleado in self.empleados:
            cuenta = empleado.buscar_cuenta(numero_cuenta)
            if cuenta:
                return cuenta
        return None

    def mostrar_informacion_todos_empleados(self):
        for empleado in self.empleados:
            empleado.mostrar_informacion()
            print()

    def mostrar_todas_las_cuentas(self):
        for empleado in self.empleados:
            for cuenta in empleado.cuentas:
                cuenta.mostrar_informacion()


banco = Banco()

while True:
    print("----- Menú -----")
    print("1. Crear cuenta para un empleado")
    print("2. Acceder a la cuenta de un empleado")
    print("3. Mostrar información de todos los usuarios")
    print("4. Mostrar información de un usuario en específico")
    print("5. Mostrar todas las cuentas del banco")
    print("6. Mostrar información de una cuenta en específico")
    print("7. Salir")

    opcion = int(input("Seleccione una opción: "))

    if opcion == 1:
        nombre = input("Ingrese el nombre del empleado: ")
        if not banco.buscar_empleado(nombre):
            banco.agregar_empleado(nombre)

        tipo_cuenta = input("Ingrese el tipo de cuenta (A, B o C): ").upper()
        while tipo_cuenta not in ['A', 'B', 'C']:
            tipo_cuenta = input("Ingrese A, B o C: ").upper()

        numero_cuenta = int(input("Ingrese el número de cuenta: "))
        banco.buscar_empleado(nombre).agregar_cuenta(numero_cuenta, tipo_cuenta)

        print("Cuenta creada para el empleado", nombre)

    elif opcion == 2:
        nombre_empleado = input("Ingrese el nombre del empleado: ")
        empleado = banco.buscar_empleado(nombre_empleado)
        if not empleado:
            print("No se encontró ningún empleado con ese nombre.")
        else:
            while True:
                print("----- Menú de Cuenta -----")
                print("1. Agregar dinero a una cuenta")
                print("2. Retirar dinero de una cuenta")
                print("3. Volver al menú principal")

                opcion_cuenta = int(input("Seleccione una opción: "))

                if opcion_cuenta == 1:
                    numero_cuenta = int(input("Ingrese el número de cuenta: "))
                    cuenta = empleado.buscar_cuenta(numero_cuenta)
                    if not cuenta:
                        print("No se encontró ninguna cuenta con ese número.")
                    else:
                        cantidad = float(input("Ingrese la cantidad a depositar (positiva): "))
                        cuenta.depositar(cantidad)

                elif opcion_cuenta == 2:
                    numero_cuenta = int(input("Ingrese el número de cuenta: "))
                    cuenta = empleado.buscar_cuenta(numero_cuenta)
                    if not cuenta:
                        print("No se encontró ninguna cuenta con ese número.")
                    else:
                        cantidad = float(input("Ingrese la cantidad a retirar: "))
                        cuenta.retirar(cantidad)

                elif opcion_cuenta == 3:
                    print("Volviendo al menú principal...")
                    break

                else:
                    print("Opción no válida. Por favor, seleccione una opción válida.")

    elif opcion == 3:
        banco.mostrar_informacion_todos_empleados()

    elif opcion == 4:
        nombre_empleado = input("Ingrese el nombre del empleado: ")
        empleado = banco.buscar_empleado(nombre_empleado)
        if not empleado:
            print("No se encontró ningún empleado con ese nombre.")
        else:
            empleado.mostrar_informacion()

    elif opcion == 5:
        banco.mostrar_todas_las_cuentas()

    elif opcion == 6:
        numero_cuenta = int(input("Ingrese el número de cuenta: "))
        cuenta = banco.buscar_cuenta(numero_cuenta)
        if not cuenta:
            print("No hay cuenta con ese número")
        else:
            cuenta.mostrar_informacion()

    elif opcion == 7:
        break

    else:
        print("Seleccione una opción válida.")
