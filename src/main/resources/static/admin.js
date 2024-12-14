document.addEventListener("DOMContentLoaded", function () {
    const galeria = document.getElementById("galeria");
    const modal = document.getElementById("modal-eliminar");
    const formEliminar = document.getElementById("form-eliminar");
    const motivoInput = document.getElementById("motivo");
    const cancelarBtn = document.getElementById("cancelar");
    const notificaciones = document.getElementById("notificaciones");
    let archivoIdSeleccionado = null;

    // Obtener el token CSRF y su nombre de cabecera
    const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
    const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

    // Función para mostrar una notificación
    function mostrarNotificacion(mensaje, tipo = "success") {
        const notificacion = document.createElement("div");
        notificacion.className = `notificacion ${tipo}`;
        notificacion.innerHTML = `
            <span>${mensaje}</span>
            <button class="cerrar">&times;</button>
        `;

        // Cerrar notificación manualmente
        notificacion.querySelector(".cerrar").addEventListener("click", () => {
            notificacion.remove();
        });

        // Agregar notificación al contenedor
        notificaciones.appendChild(notificacion);

        // Eliminar automáticamente después de 5 segundos
        setTimeout(() => {
            notificacion.remove();
        }, 5000);
    }

    // Fetch para cargar la galería
    fetch("/api/archivos")
        .then(response => response.json())
        .then(data => {
            data.forEach(archivo => {
                const item = document.createElement("div");
                item.className = "galeria-item";

                item.innerHTML = `
                    <img src="${archivo.rutaArchivo}" alt="${archivo.nombreDispositivo}">
                    <div class="galeria-texto">
                        <p><strong>Dispositivo:</strong> ${archivo.nombreDispositivo}</p>
                        <p><strong>Contacto:</strong> ${archivo.emailContacto}</p>
                    </div>
                    <button class="btn-eliminar" data-id="${archivo.id}">Eliminar</button>
                `;

                galeria.appendChild(item);
            });

            // Asignar evento de clic al botón de eliminar
            document.querySelectorAll(".btn-eliminar").forEach(button => {
                button.addEventListener("click", function () {
                    archivoIdSeleccionado = this.getAttribute("data-id");
                    modal.style.display = "flex";
                });
            });
        })
        .catch(error => {
            mostrarNotificacion("Error al cargar la galería.", "error");
            console.error("Error al cargar la galería:", error);
        });

    // Evento para cancelar el modal
    cancelarBtn.addEventListener("click", function () {
        modal.style.display = "none";
        motivoInput.value = ""; // Limpiar el motivo
    });

    // Evento para confirmar la eliminación
    formEliminar.addEventListener("submit", function (e) {
        e.preventDefault();

        const motivo = motivoInput.value.trim();

        if (archivoIdSeleccionado && motivo) {
            fetch(`/admin/imagenes/${archivoIdSeleccionado}?motivo=${encodeURIComponent(motivo)}`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                    [csrfHeader]: csrfToken // Incluir el token CSRF en la cabecera
                }
            })
                .then(response => {
                    if (response.ok) {
                        mostrarNotificacion("Imagen eliminada con éxito.");
                        // Remover la imagen de la galería
                        const item = document.querySelector(`.btn-eliminar[data-id="${archivoIdSeleccionado}"]`).parentElement;
                        galeria.removeChild(item);
                    } else {
                        mostrarNotificacion("Error al eliminar la imagen.", "error");
                    }
                    modal.style.display = "none";
                    motivoInput.value = ""; // Limpiar el motivo
                })
                .catch(error => {
                    mostrarNotificacion("Error al eliminar la imagen.", "error");
                    console.error("Error al eliminar la imagen:", error);
                    modal.style.display = "none";
                    motivoInput.value = ""; // Limpiar el motivo
                });
        }
    });
});
