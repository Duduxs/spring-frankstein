let stompClient = null;
$(document).ready(function() {
    console.log("Olá!");
    const socket = new SockJS('/son-socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, (stompCon) => {
        console.log("Conectado com sucesso", stompCon);
            stompClient.send('/app/hello', {}, JSON.stringify({message: "A new connection"}));

            stompClient.subscribe('/topic/public', function(data)
            {
                console.log("Data -> ", data);
                console.log("Parse -> ", JSON.parse(data.body));
            });
    });
});