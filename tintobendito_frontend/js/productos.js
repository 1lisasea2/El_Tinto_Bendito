const url="http://localhost:8080/tintobendito_backend/api/productos";

const container = document.getElementById('tbl-body');
const modalProductos = new bootstrap.Modal(document.getElementById('mod-productos'));
const modalConfirm = new bootstrap.Modal(document.getElementById('mod-confirm'));
const formProductos = document.getElementById('frm-modal');
const idProducto = document.getElementById('idProducto');
const nomProducto = document.getElementById('nomProducto');
const descProducto = document.getElementById('descProducto');
const catProducto = document.getElementById('catProducto');
const urlImgProducto = document.getElementById('urlImgProducto');
const preProducto = document.getElementById('preProducto');
const dispProducto = document.getElementById('dispProducto');
const estProducto = document.getElementById('estProducto');
const btnCrearProducto = document.getElementById('btnCrearProducto');
const btnGuardarProducto = document.getElementById('btn-guardar_mod');
const btnCloseConfirm = document.getElementById('btn-close-confirm');

let dbResultSet = '';
let opcion = '';

//Objeto AJAX para las opciones del CRUD
const ajax = (options) => { 
    let { url, method, success, error, data } = options;
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState !== 4) return;
        if (xhr.status >= 200 && xhr.status < 300) {
            let json = JSON.parse(xhr.responseText);
            success(json);
        } else {
            let message = xhr.statusText || "Ocurrió un error";
            error(`Error ${xhr.status}: ${message}`);
        }
    }); 

    xhr.open(method || "GET", url);
    xhr.setRequestHeader("Content-type", "application/json;");
    xhr.send(JSON.stringify(data));
};

const getAll = () => {
    ajax({
        url: url,
        method: "GET",
        success: (res) => {
            console.log(res);
            res.forEach((productos) => {
                dbResultSet += `<tr>
                    <td>${productos.id_prod}</td>
                    <td>${productos.nombre_prod}</td>
                    <td>${productos.desc_prod}</td>
                    <td>${productos.id_categoria}</td>
                    <td>${productos.url_img_prod}</td>
                    <td>${productos.precio_prod}</td>
                    <td>${productos.disp_prod}</td>
                    <td>${productos.estado_prod}</td>
                    <td><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                </tr>`
            });
            container.innerHTML = dbResultSet;
        },
        error: (err) => {
            console.log(err);
            $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
        },
    });
};



btnCrearProducto.addEventListener('click', () => {
    idProducto.value = '';
    nomProducto.value = '';
    descProducto.value = '';
    catProducto.value = '';
    urlImgProducto.value = '';
    preProducto.value = '';
    dispProducto.value = '';
    estProducto.value = '';
    opcion = 'crear';
})

document.addEventListener("DOMContentLoaded", getAll); 

document.addEventListener('click', e => {
    if (e.target.matches(".btnBorrar")) { 
        const fila = e.target.parentNode.parentNode; 
        const id = fila.firstElementChild.innerHTML; 
        const prod = fila.children[1].innerHTML; 
        console.log(id); 
        alertify.confirm('¡Atención!',`¿Estás seguro de eliminar el producto ${id} - ${prod}?`, 
            function () { 
                ajax({ 
                    url: url + "/" + id, 
                    method: "DELETE", 
                    headers: { 
                        'Content-Type': 'application/json' 
                    }, 
                    success: res => modalConfirm.show(), 
                    error: err => alert(err), 
                }); 
            }, 
            function () { 
                alertify.error('Cancel') 
            }); 
    } 
    if (e.target.matches(".btnEditar")) { 
        const fila = e.target.parentNode.parentNode; 
        idProducto.value = fila.children[0].innerHTML;
        nomProducto.value = fila.children[1].innerHTML;
        descProducto.value = fila.children[2].innerHTML;
        catProducto.value = fila.children[3].innerHTML;
        urlImgProducto.value = fila.children[4].innerHTML;
        preProducto.value = fila.children[5].innerHTML;
        dispProducto.value = fila.children[6].innerHTML;
        estProducto.value = fila.children[7].innerHTML;
        idProducto.disabled = true; 
        opcion = 'editar'; 
        modalProductos.show(); 
    } 
})


btnGuardarProducto.addEventListener('click', e => {
    e.preventDefault();

    ajax({
        url: url,
        method: opcion == 'editar' ? "PUT" : "POST",
        headers: {"Content-type":"application/json"},
        success: res => {modalConfirm.show()},
        error: err => {$form.insertAdjacentHTML('afterend', `<p><b>${err}</b></p>`)},
        data: opcion == "editar" ? {
            "nombre_prod": nomProducto.value,
            "desc_prod": descProducto.value,
            "id_categoria": catProducto.value,
            "url_img_prod": urlImgProducto.value,
            "precio_prod": preProducto.value,
            "disp_prod": dispProducto.value,
            "estado_prod": estProducto.value,
            "id_prod": idProducto.value
        } : {
            "nombre_prod": nomProducto.value,
            "desc_prod": descProducto.value,
            "id_categoria": catProducto.value,
            "url_img_prod": urlImgProducto.value,
            "precio_prod": preProducto.value,
            "disp_prod": dispProducto.value,
            "estado_prod": estProducto.value,
        }
    });
    modalProductos.hide();
})

btnCloseConfirm.addEventListener('click', e => {
    location.reload();
})
