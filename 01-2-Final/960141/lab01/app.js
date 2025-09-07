const express = require('express'); 
const mysql = require('mysql');
const cors = require('cors');
const app = express();
const port = 3000;

const connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'',
    database:'682110161'
});

connection.connect((err) => {
    if(err) {
        console.error('Error connecting to MYSQL:', err);
        return;
    }
    console.log('Connected to MySQL successfully !')
});

app.use(cors());
app.use(express.json());

app.get("/", (req,res) => {
    res.send("Welcome to Product management system");
});

app.listen(port, () => {
    console.log(`Server is listening on port ${port}`);
});

// R : READ (GET)

app.get('/product', (req,res) => {
    const query = "SELECT * FROM product";
    connection.query(query, (err,results) => {
        if(err) {
            console.error('Error fetching items; ', err);
            return res.status(500).json({message: 'Error fetching items'});
        }
        res.json(results);
    });
});

// C : CREATE (POST)

app.post('/product', (req, res) => {
    const items = req.body;
    const query = `INSERT INTO product (productName, price, qty) VALUES ('${items.productName}',${items.price},${items.qty})`;
    connection.query(query, (err, results) => {
        if(err) {
            console.error('Error adding item; ', err);
            return res.status(500).json({message: 'Error adding items'});
        }
        // res.status(201).json({id: result.insertId, productName: results.productName});
        // res.json(results);
        res.status(201).json({id: results.insertId, productName: results.productName});
        // res.json(results);

    });
});

//  U : UPDATE (PUT)

app.put('/product/:id', (req, res) => {
    const id = req.params.id;
    const items = req.body;
    const query = `UPDATE product SET productName='${items.productName}', price=${items.price}, qty=${items.qty} WHERE productID=${id}`;
    connection.query(query, (err, results) => {
        if(err) {
            console.error('Error updating item; ', err);
            return res.status(500).json({message: 'Error updating items'});
        }
        if(results.affectedRows === 0) {
            return res.status(404).json({message: 'Item not found'});
        }
        res.json(results);
    });
});

app.get('/product/:id', (req, res) => {
    const id = req.params.id;
    const query = `SELECT * FROM product WHERE productID=${id}`;

    connection.query(query, (err, results) => {
        if(err) {
            console.error('Error fetching item; ', err);
            return res.status(500).json({message: 'Error fetching item'});
        }
        
        res.json(results);
    });
});

// D : DELETE (DELETE)

app.delete('/product/:id', (req, res) => {
    const id = req.params.id;
    const items = req.body;
    const query = `DELETE FROM product WHERE productID=${id}`;
    connection.query(query, (err, results) => {
        if(err) {
            console.error('Error deleting item; ', err);
            return res.status(500).json({message: 'Error deleting item'});
        }
        if(results.affectedRows === 0) {
            return res.status(404).json({message: 'Item not found'});
        }
        res.json({message: 'Item deleted successfully'});
    });
});