class Libro:
    def __init__(self, titulo, autor):
        self.titulo = titulo
        self.autor = autor
        self.rentado = False

    def obtener_titulo(self):
        return self.titulo

    def obtener_autor(self):
        return self.autor

    def esta_rentado(self):
        return self.rentado

    def establecer_rentado(self, rentado):
        self.rentado = rentado


class Usuario:
    def __init__(self, nombre):
        self.nombre = nombre
        self.libros_rentados = []

    def rentar_libro(self, libro):
        if not libro.esta_rentado():
            self.libros_rentados.append(libro)
            libro.establecer_rentado(True)
            print(self.nombre + " ha rentado el libro: " + libro.obtener_titulo())
        else:
            print("El libro ya está rentado.")

    def obtener_nombre(self):
        return self.nombre

    def obtener_libros_rentados(self):
        return self.libros_rentados


class Libreria:
    def __init__(self):
        self.usuarios = []
        self.libros = []

    def registrar_usuario(self, nombre):
        self.usuarios.append(Usuario(nombre))
        print("Usuario", nombre, "registrado")

    def registrar_libro(self, titulo, autor):
        self.libros.append(Libro(titulo, autor))
        print("Libro", titulo, "registrado")

    def rentar_libro(self, nombre_usuario, titulo_libro):
        usuario = None
        for u in self.usuarios:
            if u.obtener_nombre() == nombre_usuario:
                usuario = u
                break
        if usuario is None:
            print("Usuario no encontrado")
            return

        libro = None
        for l in self.libros:
            if l.obtener_titulo() == titulo_libro:
                libro = l
                break
        if libro is None:
            print("Libro no encontrado")
            return

        usuario.rentar_libro(libro)

    def listar_usuarios(self):
        print("Usuarios registrados:")
        for usuario in self.usuarios:
            print(usuario.obtener_nombre())

    def listar_libros(self):
        print("Libros registrados:")
        for libro in self.libros:
            print("Título:", libro.obtener_titulo(), ", Autor:", libro.obtener_autor())

    def listar_usuarios_con_libros(self):
        print("Usuarios que han rentado al menos un libro:")
        for usuario in self.usuarios:
            if usuario.obtener_libros_rentados():
                print(usuario.obtener_nombre())

    def listar_libros_no_rentados(self):
        print("Libros que no han sido rentados:")
        for libro in self.libros:
            if not libro.esta_rentado():
                print("Título:", libro.obtener_titulo(), ", Autor:", libro.obtener_autor())

    def listar_libros_rentados(self):
        print("Libros que han sido rentados:")
        for libro in self.libros:
            if libro.esta_rentado():
                print("Título:", libro.obtener_titulo(), ", Autor:", libro.obtener_autor())


if __name__ == "__main__":
    libreria = Libreria()

    while True:
        print("\nMenú:")
        print("1. Registrar usuario")
        print("2. Registrar libro")
        print("3. Rentar libro")
        print("4. Listar usuarios registrados")
        print("5. Listar libros registrados")
        print("6. Listar usuarios con libros rentados")
        print("7. Listar libros no rentados")
        print("8. Listar libros rentados")
        print("9. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            nombre_usuario = input("Ingrese el nombre del usuario: ")
            libreria.registrar_usuario(nombre_usuario)
        elif opcion == "2":
            titulo_libro = input("Ingrese el título del libro: ")
            autor_libro = input("Ingrese el autor del libro: ")
            libreria.registrar_libro(titulo_libro, autor_libro)
        elif opcion == "3":
            nombre = input("Ingrese el nombre del usuario: ")
            titulo = input("Ingrese el título del libro: ")
            libreria.rentar_libro(nombre, titulo)
        elif opcion == "4":
            libreria.listar_usuarios()
        elif opcion == "5":
            libreria.listar_libros()
        elif opcion == "6":
            libreria.listar_usuarios_con_libros()
        elif opcion == "7":
            libreria.listar_libros_no_rentados()
        elif opcion == "8":
            libreria.listar_libros_rentados()
        elif opcion == "9":
            break
        else:
            print("Seleccione otra opción")
