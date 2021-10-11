const getElement = (selector) => {
    const element = document.querySelector(selector);
  
    if (element) return element
    throw Error(
      `No se encontró el elemento con la clase o ID ${selector}.`
    );
  }

const txtFecha = getElement('#txtFecha');
const fechaActual = new Date().getFullYear();
const txtNombre = getElement('#txtNombre');
const txtEmail = getElement('#txtEmail');
const txtAsunto = getElement('#txtAsunto');
const btnEnviar = getElement('#btnEnviar');
const btnClose = getElement('#btnClose');
const modNom = getElement('#mod-nom');
const modMail = getElement('#mod-mail');
const modAsun = getElement('#mod-asun');
const txtFechaMod = getElement('#txtFechaMod');
const winModal = document.getElementById('modal')


btnClose.addEventListener('click', () => {
    winModal.classList.toggle('visible');
    txtNombre.value = '';
    txtEmail.value = '';
    txtAsunto.value = '';
})

btnEnviar.addEventListener('click', (ev)=> {
    ev.preventDefault();
    winModal.classList.toggle('visible');
    txtFechaMod.textContent = fechaActual;
    modNom.textContent = txtNombre.value.toUpperCase();
    modMail.textContent = txtEmail.value;
    modAsun.textContent = txtAsunto.value;
})

txtFecha.textContent = fechaActual;