const express = require('express')
const app = express()
const port = 3000
var bodyParser = require('body-parser')
const jsonParser = bodyParser.json()

// create application/x-www-form-urlencoded parser
var urlencodedParser = bodyParser.urlencoded({ extended: false })
app.use(bodyParser.json({ type: 'application/json' }))

app.get('/', (req, res) => {
	debugger;
	const {message}= req.query
	console.log(`Request from client: ${JSON.stringify(message)}`)
	res.json({
		"name": "iphone",
		"productName":"iphone" 
	})
})

app.listen(port, () => console.log(`Example app listening on port ${port}!`))