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


  socket.on('createRoom', (data)=>{
    console.log('createRoom:'+data.num)
    // console.log('createRoom:'+data.seller)
    // console.log('createRoom:'+data.buyer)
    socket.join(data.num)
    io.to(data.num).emit('roomOK', {
      msg: '채팅을 연결 했습니다.'
    })
  })
 


  socket.on('sendMsg', function(data) {
    console.log('Message from'+data.m_username+'님'+data.content);

    io.in(data.ch_num).emit('getMsg', {
      m_username : data.m_username,
      content: data.content, 
      time: data.time
    })
    console.log("메세지 보내기 끝")
  });

 
  
  socket.on('disconnect', function() {
    console.log('user disconnected: ' + socket.name);
  });


});
 console.log("Ss")
server.listen(7000);