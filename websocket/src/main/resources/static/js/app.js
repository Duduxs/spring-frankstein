let stompClient = null;
$(document).ready(function() {
    console.log("Olá!");
    const socket = new SockJS('/son-socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, (stompCon) => {
        console.log("Conectado com sucesso", stompCon);
    });

});