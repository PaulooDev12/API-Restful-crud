async function criarUsuario() {
    const nomeInput = document.getElementById("nome");
    const emailInput = document.getElementById("email");
    const nomeErro = document.getElementById("erroNome");

    const nome = nomeInput.value;
    const email = emailInput.value;

    if (!nome || !email) {
        nomeInput.classList.add("input-erro");
        emailInput.classList.add("input-erro");
        nomeErro.classList.add("show");
        document.createElement("error-message");
         document.createElement("error-message.show");


        setTimeout(() => {
            nomeInput.classList.remove("input-erro");
            emailInput.classList.remove("input-erro");
            
        }, 300);

        return;
    }
    if(nome && email){
        nomeErro.classList.remove("show");
    }

    await fetch("http://localhost:8080/users/usuario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nome, email })
    });

    listarUsuarios();
}


const nomeInput = document.getElementById("nome");
const emailInput = document.getElementById("email");
const btn = document.getElementById("btn");

btn.onclick = criarUsuario;

[nomeInput, emailInput].forEach(input => {
    input.addEventListener("keydown", (e) => {
        if (e.key === "Enter") criarUsuario();
    });
});
async function listarUsuarios() { 
    const res = await fetch("http://localhost:8080/users/listar"); 
    const usuarios = await res.json(); const lista = document.getElementById("lista"); 
    lista.innerHTML = ""; usuarios.forEach(u => { 
        lista.innerHTML += `<li>${u.nome}  -  ${u.email}</li>`; }); 
    }
    async function atualizarUsuario(id) { await fetch("http://localhost:8080/users/${id}"
        ,{ method: "PUT", headers: { 
            "Content-Type": "application/json" }, 
            body: JSON.stringify({ nome, email }) }); 
            listarUsuarios();
        }