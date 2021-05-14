var app = require('express')();
var server = require('http').createServer(app);
var axios = require('axios')
var io = require('socket.io')(server,{
  pingTimeout: 1000,
  cors: {
    origin: '*',
  }
});

app.all('/*', function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "X-Requested-With");
  next();
});

app.get('/', function(req, res) {
  res.sendFile('Hellow Chating App Server');
});

io.on('connection', function(socket){

  console.log('connection')
  var room 

  socket.on('createRoom', (data)=>{
    console.log('createRoom:'+data.ch_num)
    room = data.ch_num
    socket.join(data.ch_num)

    // socket.set('ch_num', data.num)
    io.to(room).emit('roomOK', {
      msg: '채팅을 연결 했습니다.'
    })
  })


  console.log(room)
 


  socket.on('sendMsg', function(data) {
    console.log('Message from'+data.m_username + data.content);

    io.in(room).emit('getMsg', {
      m_username : data.m_username,
      content: data.content, 
      time: data.time
    })
    console.log("메세지 보내기 끝")
  });



 
  
  socket.on('disconnect', function() {
    socket.leave(room)
    console.log('user disconnected: '+room);
  });
  


});
 console.log("Ss")
server.listen(7000);