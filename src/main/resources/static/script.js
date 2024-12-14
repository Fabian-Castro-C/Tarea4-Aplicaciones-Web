$(document).ready(function () {
    // Cargar dispositivos al cargar la página
    $.get("/api/dispositivos", function (data) {
        const tbody = $("#dispositivos-tbody");
        tbody.empty();

        data.forEach(dispositivo => {
            const row = `
                <tr>
                    <td id="dispositivo-id-${dispositivo.id}">${dispositivo.id}</td>
                    <td id="dispositivo-nombre-${dispositivo.id}">${dispositivo.nombre}</td>
                    <td id="dispositivo-tipo-${dispositivo.id}">${capitalizeFirstLetter(dispositivo.tipo)}</td>
                    <td id="dispositivo-anosUso-${dispositivo.id}">${dispositivo.anosUso}</td>
                    <td id="dispositivo-estado-${dispositivo.id}">${formatEstado(dispositivo.estado)}</td>
                    <td>
                        <button id="like-button-${dispositivo.id}" onclick="likeDispositivo(${dispositivo.id})">👍 (${dispositivo.contadorMegusta})</button>
                        <button id="dislike-button-${dispositivo.id}" onclick="dislikeDispositivo(${dispositivo.id})">👎 (${dispositivo.contadorNomegusta})</button>
                    </td>
                </tr>
            `;
            tbody.append(row);

            // Inicializar el estado de los botones
            updateButtonState(dispositivo.id, false, false);
        });
    });

    // Función para manejar "Me gusta"
    window.likeDispositivo = function (id) {
        // Incrementar el contador de "Me gusta"
        $.post(`/api/dispositivos/${id}/like`, function (data) {
            // Actualizar el contador de likes en el DOM
            $(`#like-button-${id}`).text(`👍 (${data.contadorMegusta})`);

            // Si el botón "No me gusta" está desactivado, decrementar el dislike
            if ($(`#dislike-button-${id}`).prop('disabled')) {
                $.post(`/api/dispositivos/${id}/undislike`, function (data) {
                    // Actualizar el contador de dislikes en el DOM
                    $(`#dislike-button-${id}`).text(`👎 (${data.contadorNomegusta})`);
                }).fail(function () {
                    console.error("Error al decrementar 'No me gusta'");
                });
            }

            // Desactivar botón "Me gusta" y activar "No me gusta"
            updateButtonState(id, true, false);
        }).fail(function () {
            console.error("Error al incrementar 'Me gusta'");
        });
    };

    // Función para manejar "No me gusta"
    window.dislikeDispositivo = function (id) {
        // Incrementar el contador de "No me gusta"
        $.post(`/api/dispositivos/${id}/dislike`, function (data) {
            // Actualizar el contador de dislikes en el DOM
            $(`#dislike-button-${id}`).text(`👎 (${data.contadorNomegusta})`);

            // Si el botón "Me gusta" está desactivado, decrementar el like
            if ($(`#like-button-${id}`).prop('disabled')) {
                $.post(`/api/dispositivos/${id}/unlike`, function (data) {
                    // Actualizar el contador de likes en el DOM
                    $(`#like-button-${id}`).text(`👍 (${data.contadorMegusta})`);
                }).fail(function () {
                    console.error("Error al decrementar 'Me gusta'");
                });
            }

            // Desactivar botón "No me gusta" y activar "Me gusta"
            updateButtonState(id, false, true);
        }).fail(function () {
            console.error("Error al incrementar 'No me gusta'");
        });
    };

    // Función para actualizar el estado de los botones
    function updateButtonState(id, likeDisabled, dislikeDisabled) {
        $(`#like-button-${id}`).prop('disabled', likeDisabled);
        $(`#dislike-button-${id}`).prop('disabled', dislikeDisabled);
    }
});

// Función para formatear el texto del estado de un dispositivo
function formatEstado(estado) {
    switch (estado) {
        case "FUNCIONA_PERFECTO":
            return "Funciona perfecto";
        case "FUNCIONA_A_MEDIAS":
            return "Funciona a medias";
        case "NO_FUNCIONA":
            return "No funciona";
        default:
            return "Desconocido";
    }
}

// Funcion para capitalizar la primera letra de una cadena
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1).toLowerCase();
}