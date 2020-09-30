var express = require('express');
var app = express();
var firebase = require("firebase");

firebase.initializeApp({
  serviceAccount: "/tipapp-d06db-firebase-adminsdk-bbd38-e0ad5fd6fc.json",
  databaseURL: "https://tipapp-d06db.firebaseio.com"
});

var db = firebase.database();
var ref = db.ref("/tippers");

app.get('/', function (req, res) {
   res.sendFile( __dirname + "/" + "index.html" );
})

app.get('/process_get', function (req, res) {
   
   if(req.query.tipperDropdown == 1){
   	  ref = db.ref("/tippers/Alperen");
   }else if(req.query.tipperDropdown == 2){
   	  ref = db.ref("/tippers/Göktürk");
   }

   ref.push({
	  Home: req.query.home_parameter,
	  Away: req.query.away_parameter,
	  Code: req.query.code_parameter,
	  Prediction: req.query.prediction_parameter
   });

   res.redirect('/');
})

const PORT = process.env.PORT || 3000;

var server = app.listen(PORT, function () {
   var host = server.address().address
   var port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
})