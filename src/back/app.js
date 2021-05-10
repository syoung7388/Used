var app = require('express')();
var server = require('http').createServer(app);
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

  var seller = null
  var buyer = null
  var num = null

  socket.on('createRoom', (data)=>{
    console.log('createRoom:'+data.num)
    console.log('createRoom:'+data.seller)
    console.log('createRoom:'+data.buyer)
    this.seller = data.seller
    this.buyer = data.buyer
    this.num = data.num
    socket.join(num)
    io.to(num).emit('roomOK', {
      msg: '채팅을 연결 했습니다.'
    })
  })


  socket.on('sendMsg', function(data) {
    console.log('Message from' +data.content+data.m_username);
    if(this.seller == data.m_username || this.buyer == data.m_username){
      socket.broadcast.to(num).emit('getMsg', {
        m_username : data.m_username,
        content: data.content
      })

    }

  });
  socket.on('room', (data)=>{
    console.log(data)
    socket.join(data.num)
    io.to(data.num).emit('rooreply', {
      message : '룸번호:'+data.num+'/입장자:'+data.username
    })


  })
 
  
  socket.on('disconnect', function() {
    console.log('user disconnected: ' + socket.name);
  });


});
 console.log("Ss")
server.listen(7000);